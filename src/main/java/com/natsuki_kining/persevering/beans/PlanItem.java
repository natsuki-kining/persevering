package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanItemType;
import lombok.Data;

/**
 * 计划项
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 18:03
 */
@Data
public class PlanItem {

    private String itemName;
    private PlanItemType planItemType;
    //权重->计算百分比
    private int weight;
    //指定时间段
    private String hour;
}
