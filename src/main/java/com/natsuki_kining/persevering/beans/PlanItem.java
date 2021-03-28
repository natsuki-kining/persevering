package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.HourPeriods;
import com.natsuki_kining.persevering.enums.PlanItemType;
import com.natsuki_kining.persevering.enums.PlanItemWeight;
import lombok.Data;

/**
 * 计划项
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 18:03
 */
@Data
public class PlanItem {

    /**
     * 后面可以改成能填多项
     */
    private String name;
    private PlanItemType type;
    //权重->计算百分比
    private Double weight;
    private PlanItemWeight planItemWeight;
    //指定时间段
    private Float startTime;
    private Float endTime;

}
