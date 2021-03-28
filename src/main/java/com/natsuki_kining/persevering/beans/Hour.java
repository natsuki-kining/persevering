package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.HourPeriods;
import lombok.Data;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/27 1:08
 */
@Data
public class Hour {

    private String planName;
    private HourPeriods hourPeriods;
    private int hour;
}
