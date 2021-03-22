package com.natsuki_kining.persevering.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.natsuki_kining.persevering.converter.ConverterEnum;
import lombok.Getter;

/**
 * 计划类型
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:53
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanType implements ConverterEnum {

    /**
     *
     */
    DAILY_PLAN("日计划", 0),
    WEEKLY_PLAN("周计划", 1),
    MONTHLY_PLAN("月计划", 2),
    ANNUAL_PLAN("年计划", 3);

    private final String name;
    private final Integer value;

    PlanType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @JsonCreator
    public static PlanType jsonCreator(Integer value) {
        for (PlanType planType : values()) {
            if (value.intValue() == planType.getValue().intValue()) {
                return planType;
            }
        }
        return null;
    }

}
