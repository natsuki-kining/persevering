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
    THINK("思考", 0),
    REMEMBER("记忆", 1),
    RELAX("放松", 2),
    STUDY("练习", 3),
    EXERCISE("锻炼", 4),
    READ_BOOK("看书", 5),
    SLEEP("睡觉", 6),
    ;
    private final String name;
    private final Integer value;

    PlanItemType(String name, Integer value) {
        this.name = name;
        this.value = value;
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
