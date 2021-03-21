package com.natsuki_kining.persevering.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/27 1:04
 */
public class Day {

    private String planName;
    private final List<Hour> hours = new ArrayList<>(24);

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
