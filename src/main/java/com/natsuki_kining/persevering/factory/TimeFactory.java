package com.natsuki_kining.persevering.factory;

import com.natsuki_kining.persevering.beans.Day;
import com.natsuki_kining.persevering.beans.Plan;
import com.natsuki_kining.persevering.enums.PlanType;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/27 0:54
 */
public class TimeFactory {

    public static List<Day> getDay(Plan plan) {
        int size = 0;
        if (plan.getPlanType() == PlanType.WEEKLY_PLAN) {
            size = 7;
        } else if (plan.getPlanType() == PlanType.MONTHLY_PLAN) {
            Date date;
            if (StringUtils.isBlank(plan.getPlanTime())) {
                date = new Date();
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
                try {
                    date = simpleDateFormat.parse(plan.getPlanTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                    date = new Date();
                }
            }
            size = dayByMonth(date);
        } else if (plan.getPlanType() == PlanType.MONTHLY_PLAN) {
            Date date;
            if (StringUtils.isBlank(plan.getPlanTime())) {
                date = new Date();
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
                try {
                    date = simpleDateFormat.parse(plan.getPlanTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                    date = new Date();
                }
            }
            size = runNian(date) ? 366 : 365;
        }
        return new ArrayList<>(size);
    }

    private static int dayByMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            //对于2月份需要判断是否为闰年
            case 2:
                if (runNian(date)) {
                    return 29;
                } else {
                    return 28;
                }

            default:
                return 0;
        }
    }

    private static boolean runNian(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}