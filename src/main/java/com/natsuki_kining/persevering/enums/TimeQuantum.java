package com.natsuki_kining.persevering.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.natsuki_kining.persevering.converter.ConverterEnum;
import lombok.Getter;

/**
 * 时间段
 *
 * @Author( natsuki_kining
 * @Date( 2020/10/25 16:43
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TimeQuantum implements ConverterEnum {

    /**
     * 凌晨
     */
    LING_CHEN("凌晨", 0, 3, 6),
    /**
     * 早晨
     */
    ZAO_CHEN("早晨", 1, 6, 8),
    /**
     * 上午
     */
    SHANG_WU("上午", 2, 8, 11),
    /**
     * 中午
     */
    ZHONG_WU("中午", 3, 11, 13),
    /**
     * 下午
     */
    XIA_WU("下午", 4, 13, 17),
    /**
     * 傍晚
     */
    BANG_WAN("傍晚", 5, 17, 19),
    /**
     * 晚上
     */
    WAN_SHANG("晚上", 6, 19, 23),
    /**
     * 深夜
     */
    SHEN_YE("深夜", 7, 23, 3);

    private final String name;
    private final Integer value;

    /**
     * 对应的北京时间开始时间
     */
    private final Integer startTime;

    /**
     * 对应的北京时间结束时间
     */
    private final Integer endTime;

    TimeQuantum(String name, Integer value, Integer startTime, Integer endTime) {
        this.name = name;
        this.value = value;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @JsonCreator
    public static TimeQuantum jsonCreator(Integer value) {
        for (TimeQuantum timeQuantum : values()) {
            if (value.intValue() == timeQuantum.getValue().intValue()) {
                return timeQuantum;
            }
        }
        return null;
    }
}
