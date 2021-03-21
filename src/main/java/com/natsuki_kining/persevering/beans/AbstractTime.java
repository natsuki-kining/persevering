package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 22:56
 */
@Getter
public class AbstractTime {

    public AbstractTime(PlanType planType){
        this.planType = planType;
    }

    public AbstractTime(PlanType planType,int dayCount){
        this.planType = planType;
        this.dayCount = dayCount;
    }

    private PlanType planType;

    /**
     * 时间天数
     */
    private int dayCount;

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    /**
     * 天数名称：周->周一，周二……。月，年->几号。
     */
    private List<String> dayName;

    public void setDayName(List<String> dayName) {
        this.dayName = dayName;
    }
}
