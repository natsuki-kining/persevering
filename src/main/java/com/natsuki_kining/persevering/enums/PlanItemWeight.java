package com.natsuki_kining.persevering.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.natsuki_kining.persevering.converter.ConverterEnum;
import lombok.Getter;

import javax.xml.bind.annotation.XmlType;

/**
 * 权重
 *
 * @Author natsuki_kining
 * @Date 2021/3/21 16:20
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PlanItemWeight implements ConverterEnum {

    /**
     *
     */
    IMPORTANT_URGENT("重要紧急", 3),
    URGENT("紧急", 2),
    IMPORTANT("重要", 1),
    DEFAULT("默认", 0),
    UN_IR("不重要不紧急", -1);


    private final String name;
    private final Integer value;

    PlanItemWeight(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    @JsonCreator
    public static PlanItemWeight jsonCreator(Integer value) {
        for (PlanItemWeight planItemWeight : values()) {
            if (value.intValue() == planItemWeight.getValue().intValue()) {
                return planItemWeight;
            }
        }
        return null;
    }
}
