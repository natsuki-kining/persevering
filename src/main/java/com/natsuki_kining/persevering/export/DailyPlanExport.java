package com.natsuki_kining.persevering.export;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.dto.DailyPlanDTO;
import com.natsuki_kining.persevering.dto.PlanDTO;
import org.springframework.stereotype.Component;

/**
 * 日計劃導出
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 18:02
 **/
@Component("dailyPlan")
public class DailyPlanExport extends AbstractExport{

    @Override
    protected PlanDTO initPlanDTO(PlanVO planVO) {
        return new DailyPlanDTO(planVO);
    }
}
