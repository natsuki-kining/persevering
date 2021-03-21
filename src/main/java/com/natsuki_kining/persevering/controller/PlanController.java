package com.natsuki_kining.persevering.controller;

import com.natsuki_kining.persevering.beans.Plan;
import com.natsuki_kining.persevering.beans.PlanItem;
import com.natsuki_kining.persevering.enums.PlanType;
import com.natsuki_kining.persevering.utils.ChartsUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 计划controller
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/24 20:37
 */
@Controller
@RequestMapping("/plan")
public class PlanController {

    @GetMapping("doIt")
    public void doIt(HttpServletRequest request, HttpServletResponse response, Plan plan) throws IOException {
        PlanType planType = plan.getType();
        //根据planType选择计划表、时间的划分等
        List<PlanItem> planItems = plan.getItems();
        planItems.forEach(planItem -> {

        });

        //导出Excel
        String sheetName = "计划表31jj";
        //创建工作薄对象
        XSSFWorkbook workbook=new XSSFWorkbook();
        //创建工作表对象
        XSSFSheet sheet = workbook.createSheet(sheetName);

        ChartsUtil.createPie(sheet);

        //创建工作表的行
//        HSSFRow row = sheet.createRow(0);
//        row.createCell(2).setCellValue("aaaaaaaaaaaa");
//        row.createCell(0).setCellValue(new Date());
//        workbook.setSheetName(0,"sheet的Name");

        //文档输出
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        response.setContentType("application/vnd.ms-excel");
        String codedFileName = java.net.URLEncoder.encode(sheetName, "UTF-8");
        if (agent.contains("firefox")) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + new String(sheetName.getBytes(), "ISO8859-1") + ".xlsx" );
        } else {
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xlsx");
        }

        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }

}
