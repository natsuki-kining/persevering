package com.natsuki_kining.persevering.dto;

import com.natsuki_kining.persevering.beans.Day;
import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.constant.PerseveringConstant;
import com.natsuki_kining.persevering.enums.HourPeriods;
import com.natsuki_kining.persevering.enums.TemplateFile;
import com.natsuki_kining.persevering.enums.Week;
import com.natsuki_kining.persevering.utils.TimeUtil;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 0:09
 **/
@Data
public class WeeklyPlanDTO extends PlanDTO {

    public WeeklyPlanDTO(PlanVO planVO){
        super();
        super.title = "周计划"+planVO.getNotBlankPlanTime();
        super.fileName = planVO.getName()+planVO.getNotBlankPlanTime()+planVO.getNotBlankType();
        super.templateFilePath = TemplateFile.WEEKLY_PLAN.getPath();
        this.planVO = planVO;
        initData();
    }

    private void initData(){
        Map<HourPeriods, Queue<String>> itemMap = new Hashtable<>();
        //根據權重初始化個數
        planVO.getItems().forEach(item->{
            double percentage = item.getWeight() / PerseveringConstant.DEFAULT_PLAN_ITEM_TOTAL;
            double itemTotal = Math.floor(percentage * PerseveringConstant.DEFAULT_PLAN_ITEM_TOTAL);

            HourPeriods hourPeriods = item.getType().getHourPeriods();
            Queue<String> queue = itemMap.get(hourPeriods);
            if (queue == null){
                queue = new ConcurrentLinkedQueue();
                itemMap.put(hourPeriods,queue);
            }
            for (int i = 0; i < itemTotal; i++) {
                queue.offer(item.getName());
            }

        });





        //設置map
        Week[] weeks = Week.values();
        HourPeriods[] hourPeriods = HourPeriods.values();
        for (Week week : weeks) {
            for (HourPeriods hourPeriod : hourPeriods) {
                String weekCode = week.getCode();
                String periodCode = hourPeriod.getCode();
                String planItem = PerseveringConstant.DEFAULT_PLAN_ITEM;
                Queue<String> itemQueue = itemMap.get(hourPeriod);
                if (itemQueue != null){
                    planItem = itemQueue.poll();
                }
                for (int i = 1; i <= 2; i++) {
                    data.put(weekCode+"-"+periodCode+"-"+i,planItem);
                }
            }
        }

    }

}
