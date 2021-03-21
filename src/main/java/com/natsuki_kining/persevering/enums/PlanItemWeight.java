package com.natsuki_kining.persevering.enums;

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
public enum PlanItemWeight implements ConverterEnum {

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
}
