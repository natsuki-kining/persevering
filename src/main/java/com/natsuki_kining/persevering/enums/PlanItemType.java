package com.natsuki_kining.persevering.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.natsuki_kining.persevering.converter.ConverterEnum;
import lombok.Getter;

/**
 * 计划项类型
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 18:14
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanItemType implements ConverterEnum {

    //思考，记忆，放松，学习，锻炼，看书，睡觉
    THINK("思考", 0,HourPeriods.ZI_SHI),
    REMEMBER("记忆", 1,HourPeriods.SI_SHI),
    RELAX("放松", 2,HourPeriods.CHEN_SHI),
    STUDY("练习", 3,HourPeriods.SHEN_SHI),
    EXERCISE("锻炼", 4,HourPeriods.YOU_SHI),
    READ_BOOK("看书", 5,HourPeriods.CHEN_SHI),
    SLEEP("睡觉", 6,HourPeriods.CHOU_SHI),
    ;
    private String name;
    private Integer value;
    private HourPeriods hourPeriods;

    PlanItemType(String name, Integer value,HourPeriods hourPeriods) {
        this.name = name;
        this.value = value;
        this.hourPeriods = hourPeriods;
    }

    @JsonCreator
    public static PlanItemType jsonCreator(Integer value) {
        for (PlanItemType planItemType : values()) {
            if (value.intValue() == planItemType.getValue().intValue()) {
                return planItemType;
            }
        }
        return null;
    }
}
