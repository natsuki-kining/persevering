package com.natsuki_kining.persevering.dto;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.enums.HourPeriods;
import lombok.Data;

import java.util.*;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 0:32
 **/
@Data
public abstract class PlanDTO {

    protected PlanVO planVO;

    protected String fileName;

    protected String title;

    protected Map<HourPeriods, Queue<String>> data;

}
