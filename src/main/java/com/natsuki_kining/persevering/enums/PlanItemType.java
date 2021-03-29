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

    /**
     *
     */
    SI_KAO("思考23-24", 1, HourPeriods.ZI_SHI),
    SHUI_JIAO1("睡覺1-2", 2, HourPeriods.CHOU_SHI),
    SHUI_JIAO3("睡覺3-4", 3, HourPeriods.YIN_SHI),
    SHUI_JIAO5("睡覺5-6", 4, HourPeriods.MAO_SHI),
    DUAN_LIAN("鍛煉7-8", 5, HourPeriods.CHEN_SHI),
    JI_YI("記憶9-10", 6, HourPeriods.SI_SHI),
    JI_SUAN("計算11-12", 7, HourPeriods.WU_SHI),
    WU_XIU("午休13-14", 8, HourPeriods.WEI_SHI),
    LUO_JI("邏輯15-16", 9, HourPeriods.SHEN_SHI),
    KAN_SHU("看書17-18", 10, HourPeriods.YOU_SHI),
    WAN_FAN("晚飯19-20", 11, HourPeriods.XU_SHI),
    ZUO_TI("做題21-22", 12, HourPeriods.HAI_SHI);


    private final String name;
    private final Integer value;
    private final HourPeriods hourPeriods;

    PlanItemType(String name, Integer value, HourPeriods hourPeriods) {
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
