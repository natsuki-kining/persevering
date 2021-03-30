package com.natsuki_kining.persevering.export;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.constant.PerseveringConstant;
import com.natsuki_kining.persevering.dto.PlanDTO;
import com.natsuki_kining.persevering.enums.HourPeriods;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Queue;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 18:02
 **/
public abstract class AbstractExport {


    public void export(HttpServletRequest request, HttpServletResponse response, PlanVO planVO) throws IOException, InvalidFormatException {
        PlanDTO planDTO = initPlanDTO(planVO);
        XSSFWorkbook workbook = exportHandle(planDTO);

        //文档输出
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        response.setContentType("application/vnd.ms-excel");
        String codedFileName = java.net.URLEncoder.encode(planDTO.getFileName(), "UTF-8");
        if (agent.contains("firefox")) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + new String(planDTO.getFileName().getBytes(), "ISO8859-1") + ".xlsx");
        } else {
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xlsx");
        }

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    protected abstract PlanDTO initPlanDTO(PlanVO planVO);

    /**
     * 導出處理
     *
     * @param planDTO
     * @return
     */
    protected XSSFWorkbook exportHandle(PlanDTO planDTO) throws IOException, InvalidFormatException {
        File templateFile = getTemplateFile(getTemplatePath());
        XSSFWorkbook workbook = new XSSFWorkbook(templateFile);
        Sheet planSheet = workbook.getSheetAt(0);
        sheetDataHandle(planSheet, planDTO);
        return workbook;
    }

    protected void sheetDataHandle(Sheet planSheet, PlanDTO planDTO) {
        int lastCellNum = 0;
        for (int lastRowNum = planSheet.getLastRowNum(), currentRowNum = 0,currentCellNum = 0; currentCellNum <= lastCellNum;currentRowNum++) {
            Row currentRow = planSheet.getRow(currentRowNum);
            if (currentRow == null) {
                if (currentRowNum >= lastRowNum){
                    currentRowNum = 0;
                    currentCellNum ++;
                }
                continue;
            }
            int cellNum = currentRow.getLastCellNum();
            if (cellNum > lastCellNum){
                lastCellNum = cellNum;
            }
            XSSFCell cell = (XSSFCell) currentRow.getCell(currentCellNum);
            if (cell == null) {
                if (currentRowNum >= lastRowNum){
                    currentRowNum = 0;
                    currentCellNum ++;
                }
                continue;
            }
            if (currentRowNum >= lastRowNum){
                currentRowNum = 0;
                currentCellNum ++;
            }
            String cellValue = cell.getStringCellValue();
            if (StringUtils.isNotBlank(cellValue) && cellValue.trim().startsWith("$")) {
                String mapKet = cellValue.replace("${", "").replace("}", "");
                String data = getData(planDTO.getData(), mapKet);
                cell.setCellValue(data);
            }
            if (currentRowNum >= lastRowNum){
                currentRowNum = 0;
                currentCellNum ++;
            }
        }
    }

    protected String getData(Map<HourPeriods, Queue<String>> map, String mapKet) {
        String key = mapKet.substring(mapKet.indexOf("-") + 1).replaceAll("-\\d", "");
        Queue<String> queue = map.get(HourPeriods.getHourPeriodsByCode(key));
        if (queue != null) {
            return queue.poll();
        }
        return PerseveringConstant.DEFAULT_PLAN_ITEM;
    }


    /**
     * 模板文件路徑
     *
     * @return
     */
    protected abstract String getTemplatePath();

    protected File getTemplateFile(String path) throws FileNotFoundException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + path);
        return file;
    }
}
