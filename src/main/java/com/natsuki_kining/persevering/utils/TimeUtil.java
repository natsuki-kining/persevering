package com.natsuki_kining.persevering.utils;

import com.natsuki_kining.persevering.enums.HourPeriods;
import com.natsuki_kining.persevering.enums.PlanItemType;
import com.natsuki_kining.persevering.enums.PlanType;
import com.natsuki_kining.persevering.enums.TimeQuantum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:15
 */
public class TimeUtil {

    public final static List<HourPeriods> hourPeriodsList;
    public final static List<TimeQuantum> timeQuantumList;
    public final static List<PlanItemType> planItemTypeList;
    public final static List<PlanType> planTypeList;
    public final static Map<String, PlanItemType> hourPlanItemTypeList;

    static {
        hourPeriodsList = new ArrayList<>(12);
        hourPeriodsList.add(HourPeriods.ZI_SHI);
        hourPeriodsList.add(HourPeriods.CHOU_SHI);
        hourPeriodsList.add(HourPeriods.YIN_SHI);
        hourPeriodsList.add(HourPeriods.MAO_SHI);
        hourPeriodsList.add(HourPeriods.CHEN_SHI);
        hourPeriodsList.add(HourPeriods.SI_SHI);
        hourPeriodsList.add(HourPeriods.WU_SHI);
        hourPeriodsList.add(HourPeriods.WEI_SHI);
        hourPeriodsList.add(HourPeriods.SHEN_SHI);
        hourPeriodsList.add(HourPeriods.YOU_SHI);
        hourPeriodsList.add(HourPeriods.XU_SHI);
        hourPeriodsList.add(HourPeriods.HAI_SHI);

        timeQuantumList = new ArrayList<>(8);
        timeQuantumList.add(TimeQuantum.LING_CHEN);
        timeQuantumList.add(TimeQuantum.ZAO_CHEN);
        timeQuantumList.add(TimeQuantum.SHANG_WU);
        timeQuantumList.add(TimeQuantum.ZHONG_WU);
        timeQuantumList.add(TimeQuantum.XIA_WU);
        timeQuantumList.add(TimeQuantum.BANG_WAN);
        timeQuantumList.add(TimeQuantum.WAN_SHANG);
        timeQuantumList.add(TimeQuantum.SHEN_YE);

        planItemTypeList = new ArrayList<>(7);
        planItemTypeList.add(PlanItemType.THINK);
        planItemTypeList.add(PlanItemType.REMEMBER);
        planItemTypeList.add(PlanItemType.RELAX);
        planItemTypeList.add(PlanItemType.STUDY);
        planItemTypeList.add(PlanItemType.EXERCISE);
        planItemTypeList.add(PlanItemType.READ_BOOK);
        planItemTypeList.add(PlanItemType.SLEEP);

        planTypeList = new ArrayList<>(3);
        planTypeList.add(PlanType.WEEKLY_PLAN);
        planTypeList.add(PlanType.MONTHLY_PLAN);
        planTypeList.add(PlanType.ANNUAL_PLAN);
        //===============================================

        hourPlanItemTypeList = new HashMap<>();
        hourPlanItemTypeList.put("0",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("1",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("2",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("3",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("4",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("5",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("6",PlanItemType.EXERCISE);
        hourPlanItemTypeList.put("7",PlanItemType.THINK);
        hourPlanItemTypeList.put("8",PlanItemType.REMEMBER);
        hourPlanItemTypeList.put("9",PlanItemType.REMEMBER);
        hourPlanItemTypeList.put("10",PlanItemType.REMEMBER);
        hourPlanItemTypeList.put("11",PlanItemType.REMEMBER);
        hourPlanItemTypeList.put("12",PlanItemType.REMEMBER);
        hourPlanItemTypeList.put("13",PlanItemType.SLEEP);
        hourPlanItemTypeList.put("14",PlanItemType.STUDY);
        hourPlanItemTypeList.put("15",PlanItemType.STUDY);
        hourPlanItemTypeList.put("16",PlanItemType.STUDY);
        hourPlanItemTypeList.put("17",PlanItemType.STUDY);
        hourPlanItemTypeList.put("18",PlanItemType.EXERCISE);
        hourPlanItemTypeList.put("19",PlanItemType.READ_BOOK);
        hourPlanItemTypeList.put("20",PlanItemType.READ_BOOK);
        hourPlanItemTypeList.put("21",PlanItemType.READ_BOOK);
        hourPlanItemTypeList.put("22",PlanItemType.READ_BOOK);
        hourPlanItemTypeList.put("23",PlanItemType.RELAX);
    }

}
