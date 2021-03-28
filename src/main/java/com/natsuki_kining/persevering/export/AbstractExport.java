package com.natsuki_kining.persevering.export;

import com.natsuki_kining.persevering.beans.PlanVO;
import com.natsuki_kining.persevering.dto.PlanDTO;
import com.natsuki_kining.persevering.utils.ExportExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 18:02
 **/
public abstract class AbstractExport {


    public void export(HttpServletRequest request,HttpServletResponse response,PlanVO planVO) throws IOException, InvalidFormatException {
        PlanDTO planDTO = initPlanDTO(planVO);
        XSSFWorkbook workbook = exportHandle(planDTO);

        //文档输出
        String agent = request.getHeader("USER-AGENT").toLowerCase();
        response.setContentType("application/vnd.ms-excel");
        String codedFileName = java.net.URLEncoder.encode(planDTO.getFileName(), "UTF-8");
        if (agent.contains("firefox")) {
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + new String(planDTO.getFileName().getBytes(), "ISO8859-1") + ".xlsx" );
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
     * @param planDTO
     * @return
     */
    protected XSSFWorkbook exportHandle(PlanDTO planDTO) throws IOException, InvalidFormatException {
        File templateFile = getTemplateFile(planDTO.getTemplateFilePath());
        XSSFWorkbook workbook = new XSSFWorkbook(templateFile);
        Sheet planSheet = workbook.getSheetAt(0);
        sheetDataHandle(planSheet, planDTO);
        return workbook;
    }

    protected void sheetDataHandle(Sheet planSheet, PlanDTO planDTO) {
        for (int lastRowNum = planSheet.getLastRowNum(), currentRowNum = 0; currentRowNum <= lastRowNum; currentRowNum++) {
            Row currentRow = planSheet.getRow(currentRowNum);
            if (currentRow == null) {
                continue;
            }
            for (int lastCellNum = currentRow.getLastCellNum(), currentCellNum = 0; currentCellNum < lastCellNum; currentCellNum++) {
                XSSFCell cell = (XSSFCell) currentRow.getCell(currentCellNum);
                if (cell == null) {
                    continue;
                }
                String cellValue = cell.getStringCellValue();
                if (StringUtils.isNotBlank(cellValue) && cellValue.trim().startsWith("$")) {
                    String mapKet = cellValue.replace("${", "").replace("}", "");
                    String data = planDTO.getData().get(mapKet);
                    if (data == null) {
                        mapKet = mapKet.replaceAll("-\\d", "");
                        data = planDTO.getData().get(mapKet);
                    }
                    if (data == null){
                        data = planDTO.getPlanVO().getDefaultPlayItem();
                    }
                    cell.setCellValue(data);
                }
            }
        }
    }

    protected File getTemplateFile(String path) throws FileNotFoundException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + path);
        return file;
    }
}
