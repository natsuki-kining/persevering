package com.natsuki_kining.persevering.utils;

import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;

/**
 * TODO
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:25
 */
public class ChartsUtil {

    /**
     * 创建饼图（xlsx格式excel）
     *
     * @param sheetAt 工作表
     */
    public static void createPie(XSSFSheet sheetAt) {
        // 创建一个画布
        XSSFDrawing drawing = sheetAt.createDrawingPatriarch();
        //设置画布在excel工作表的位置
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 4, 2, 8, 15);
        // 创建一个chart对象
        XSSFChart chart = drawing.createChart(anchor);
        CTChart ctChart = chart.getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        // 创建圆环图
        CTPieChart ctPieChart = ctPlotArea.addNewPieChart();
        CTBoolean ctBoolean = ctPieChart.addNewVaryColors();
        // 允许自定义颜色
        ctBoolean.setVal(true);
        // 设置图表标题
        CTTitle title = ctChart.addNewTitle();
        //选择图表标题所在位置，此时titleRange不是单元格内容，而是 --》 '工作表名'!$A$2
        String titleRange = new CellRangeAddress(0, 0, 0, 0).formatAsString(sheetAt.getSheetName(), true);
        title.addNewTx().addNewStrRef().setF(titleRange);
        // 创建序列,并且设置选中区域
        CTPieSer ctPieSer = ctPieChart.addNewSer();
        // 设置横坐标区
        CTAxDataSource cttAxDataSource = ctPieSer.addNewCat();
        CTStrRef ctStrRef = cttAxDataSource.addNewStrRef();
        String axisDataRange = new CellRangeAddress(1, 4, 0, 0).formatAsString(sheetAt.getSheetName(), true);
        ctStrRef.setF(axisDataRange);
        // 数据区域
        CTNumDataSource ctNumDataSource = ctPieSer.addNewVal();
        CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
        // 选第1-6行,第1-3列作为数据区域 //1 2 3
        String numDataRange = new CellRangeAddress(1, 4, 1, 1).formatAsString(sheetAt.getSheetName(),
                true);
        ctNumRef.setF(numDataRange);
        // 设置标签格式
        CTDLbls newDLbls = ctPieSer.addNewDLbls();
//		newDLbls.setShowLegendKey(ctBoolean);
        newDLbls.setShowVal(ctBoolean);
//		newDLbls.setShowCatName(ctBoolean);//显示横坐标（图注）
        newDLbls.setShowPercent(ctBoolean);// 显示百分比
        newDLbls.setShowBubbleSize(ctBoolean);// 显示纵坐标（数量）
        newDLbls.setShowLeaderLines(ctBoolean);// 显示线
        // legend图注
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);//将图注放在下面（Bottom)
        ctLegend.addNewOverlay().setVal(false);// 显示图注但不与图表重叠

    }
}