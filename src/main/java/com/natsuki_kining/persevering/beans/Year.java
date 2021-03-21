package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;

/**
 * 年
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 23:02
 */
public class Year extends AbstractTime{

    public Year() {
        super(PlanType.ANNUAL_PLAN,365);
    }

}
