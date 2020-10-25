package com.natsuki_kining.persevering.enums;

/**
 * 时间段
 *
 * @Author( natsuki_kining
 * @Date( 2020/10/25 16:43
 */
public enum TimeQuantum {

    /**
     * 凌晨
     */
    LING_CHEN("凌晨",3,6),
    /**
     * 早晨
     */
    ZAO_CHEN("早晨",6,-8),
    /**
     * 上午
     */
    SHANG_WU("上午",8,11),
    /**
     * 中午
     */
    ZHONG_WU("中午",11,13),
    /**
     * 下午
     */
    XIA_WU("下午",13,17),
    /**
     * 傍晚
     */
    BANG_WAN("傍晚",17,19),
    /**
     * 晚上
     */
    WAN_SHANG("晚上",19,23),
    /**
     * 深夜
     */
    SHEN_YE("深夜",23,3)
    ;

    private final String name;

    /**
     * 对应的北京时间开始时间
     */
    private final int startTime;

    /**
     * 对应的北京时间结束时间
     */
    private final int endTime;

    TimeQuantum(String name,int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
