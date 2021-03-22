package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/27 1:04
 */
public class Day extends AbstractTime{

    private String planName;
    private final List<Hour> hours = new ArrayList<>(24);

    public Day(PlanType planType) {
        super(PlanType.DAILY_PLAN);
    }

    public List<Hour> getHours() {
        return hours;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}
