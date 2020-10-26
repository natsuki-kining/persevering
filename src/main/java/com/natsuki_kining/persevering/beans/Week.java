package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 23:02
 */
public class Week extends AbstractTime{

    public Week() {
        super(PlanType.WEEKLY_PLAN, 7);
        List<String> dayName = new ArrayList<>(getDayCount());
        dayName.add("周一");
        dayName.add("周二");
        dayName.add("周三");
        dayName.add("周四");
        dayName.add("周五");
        dayName.add("周六");
        dayName.add("周天");
        setDayName(dayName);
    }

}
