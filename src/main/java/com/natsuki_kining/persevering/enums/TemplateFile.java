package com.natsuki_kining.persevering.enums;

import lombok.Data;
import lombok.Getter;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 15:13
 **/
@Getter
public enum TemplateFile {

    /**
     * 周计划模板文件
     */
    WEEKLY_PLAN("周计划","tmp\\weekly-plan.xlsx")

    ;
    TemplateFile(String name,String path){
        this.name = name;
        this.path = path;
    }
    private String name;
    private String path;
}
