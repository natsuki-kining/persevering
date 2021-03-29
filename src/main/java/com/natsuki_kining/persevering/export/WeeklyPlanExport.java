package com.natsuki_kining.persevering.export;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.dto.PlanDTO;
import com.natsuki_kining.persevering.dto.WeeklyPlanDTO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 周計劃導出
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 18:02
 **/
@Component("weeklyPlan")
public class WeeklyPlanExport extends AbstractExport{

    @Override
    protected PlanDTO initPlanDTO(PlanVO planVO) {
        return new WeeklyPlanDTO(planVO);
    }

    @Override
    protected String getTemplatePath() {
        return "tmp\\weekly-plan.xlsx";
    }

}
