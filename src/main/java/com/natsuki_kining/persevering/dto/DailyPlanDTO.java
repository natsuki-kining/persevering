package com.natsuki_kining.persevering.dto;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.constant.PerseveringConstant;
import com.natsuki_kining.persevering.enums.HourPeriods;
import com.natsuki_kining.persevering.enums.TemplateFile;
import com.natsuki_kining.persevering.enums.Week;
import lombok.Data;

import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 0:09
 **/
@Data
public class DailyPlanDTO extends PlanDTO {

    public DailyPlanDTO(PlanVO planVO){
    }

}
