package com.natsuki_kining.persevering.export;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.dto.AnnualPlanDTO;
import com.natsuki_kining.persevering.dto.PlanDTO;
import org.springframework.stereotype.Component;

/**
 * 年計劃導出
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 18:02
 **/
@Component("annualPlan")
public class AnnualPlanExport extends AbstractExport{

    @Override
    protected PlanDTO initPlanDTO(PlanVO planVO) {
        return new AnnualPlanDTO(planVO);
    }

    @Override
    protected String getTemplatePath() {
        return null;
    }
}
