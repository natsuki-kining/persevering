package com.natsuki_kining.persevering.enums;

/**
 * 计划项类型
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 18:14
 */
public enum PlanItemType {

    //思考，记忆，放松，学习，锻炼，看书，睡觉
    THINK("思考"),
    REMEMBER("记忆"),
    RELAX("放松"),
    STUDY("练习"),
    EXERCISE("锻炼"),
    READ_BOOK("看书"),
    SLEEP("睡觉"),
    ;
    private String name;
    PlanItemType(String name){
        this.name = name;
    }
}
