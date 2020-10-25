package com.natsuki_kining.persevering.enums;

/**
 * 计划类型
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:53
 */
public enum PlanType {

    WEEKLY_PLAN("周计划"),
    MONTHLY_PLAN("月计划"),
    ANNUAL_PLAN("年计划")
    ;

    private String name;

    PlanType(String name){
        this.name = name;
    }


}
