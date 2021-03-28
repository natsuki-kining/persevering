package com.natsuki_kining.persevering.enums;

import com.natsuki_kining.persevering.beans.AbstractTime;
import com.natsuki_kining.persevering.enums.PlanType;
import com.natsuki_kining.persevering.utils.TimeUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 23:02
 */
@Getter
public enum Week {

    /**
     *
     */
    SUNDAY("sun", "周日"),
    MONDAY("mon", "周一"),
    TUESDAY("tue", "周二"),
    WEDNESDAY("wed", "周三"),
    THURSDAY("thu", "周四"),
    FRIDAY("fri", "周五"),
    SATURDAY("sat", "周六"),

    ;

    private final int totalDay = 7;
    private final String code;
    private final String name;
    Week(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
