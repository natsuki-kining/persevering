package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;

import java.util.ArrayList;
import java.util.List;

/**
 * 月
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 23:02
 */
public class Month extends AbstractTime{

    public Month() {
        super(PlanType.MONTHLY_PLAN);
    }

}
