package com.natsuki_kining.persevering.controller;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.dto.PlanDTO;
import com.natsuki_kining.persevering.dto.WeeklyPlanDTO;
import com.natsuki_kining.persevering.enums.PlanType;
import com.natsuki_kining.persevering.export.AbstractExport;
import com.natsuki_kining.persevering.utils.ExportExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

/**
 * 计划controller
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/24 20:37
 */
@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private Map<String,AbstractExport> abstractExport;

    @GetMapping("doIt")
    public void download(HttpServletRequest request,HttpServletResponse response,PlanVO planVO) throws Exception {
        PlanType planType = planVO.getType();
        abstractExport.get(planType.getCode()).export(request,response,planVO);

    }

}
