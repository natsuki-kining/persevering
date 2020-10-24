package com.natsuki_kining.persevering.controller;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
    public void doIt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sheetName = "计划表31jj";
        //创建工作薄对象
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建工作表对象
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //创建工作表的行
        HSSFRow row = sheet.createRow(0);
        row.createCell(2).setCellValue("aaaaaaaaaaaa");
        row.createCell(0).setCellValue(new Date());
        workbook.setSheetName(0,"sheet的Name");

        //文档输出
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        response.setContentType("application/vnd.ms-excel");
        String codedFileName = java.net.URLEncoder.encode(sheetName, "UTF-8");
        if (agent.contains("firefox")) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + new String(sheetName.getBytes(), "ISO8859-1") + ".xls" );
        } else {
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
        }

        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }

}
