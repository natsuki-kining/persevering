package com.natsuki_kining.persevering.dto;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.constant.PerseveringConstant;
import com.natsuki_kining.persevering.enums.HourPeriods;
import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 0:09
 **/
@Data
public class WeeklyPlanDTO extends PlanDTO {

    public WeeklyPlanDTO(PlanVO planVO) {
        super();
        super.title = "周计划" + planVO.getNotBlankPlanTime();
        super.fileName = planVO.getName() + planVO.getNotBlankPlanTime() + planVO.getNotBlankType();
        this.planVO = planVO;
        initData();
    }

    private void initData() {
        data = new HashMap<>();
        Map<HourPeriods, ItemInfo> itemInfoMap = new HashMap<>();

        AtomicReference<Double> totalWeight = new AtomicReference<>((double) 0);
        planVO.getItems().forEach(item ->
                totalWeight.updateAndGet(v -> new Double((v + item.getWeight())))
        );
        //根據權重初始化個數
        planVO.getItems().forEach(item -> {
            double percentage = item.getWeight() / totalWeight.get();
            int itemTotal = (int) Math.floor(percentage * PerseveringConstant.DEFAULT_PLAN_ITEM_TOTAL);

            HourPeriods hourPeriods = item.getType().getHourPeriods();
            ItemInfo itemInfo = itemInfoMap.get(hourPeriods);
            if (itemInfo == null) {
                itemInfo = new ItemInfo();
                itemInfoMap.put(hourPeriods, itemInfo);
            }

            itemInfo.put(item.getName(), itemTotal);
        });

        itemInfoMap.forEach((k, v) -> {
            Queue<String> queue = data.get(k);
            if (queue == null) {
                queue = new LinkedList<>();
                data.put(k, queue);
            }

            int itemCount = v.itemNameList.size();
            for (int i = 0; i < v.total; i++) {
                if (itemCount == 0) {
                    continue;
                }
                int index = i % itemCount;
                //間隔,以2為單位，間隔一個回合
                for (int j = 0; j < 2; j++) {
                    Integer itemTotal = v.itemTotalList.get(index);
                    --itemTotal;
                    v.itemTotalList.set(index, itemTotal);
                    String itemName = v.itemNameList.get(index);
                    queue.add(itemName);
                    if (itemTotal <= 0) {
                        itemCount--;
                        v.itemTotalList.remove(index);
                        v.itemNameList.remove(index);
                        break;
                    }
                }
            }
        });
    }

    private class ItemInfo {
        int total;
        List<String> itemNameList;
        List<Integer> itemTotalList;

        public ItemInfo() {
            itemNameList = new LinkedList<>();
            itemTotalList = new LinkedList<>();
        }

        public void put(String name, int itemTotal) {
            itemNameList.add(name);
            itemTotalList.add(itemTotal);
            total += itemTotal;
        }
    }


}
