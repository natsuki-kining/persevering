package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;
import lombok.Data;

import java.util.List;

/**
 * 计划表
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:50
 */
@Data
public class Plan {

    private String planName;
    private PlanType planType;
    private List<PlanItem> planItems;

}
