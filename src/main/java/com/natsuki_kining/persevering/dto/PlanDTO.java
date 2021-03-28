package com.natsuki_kining.persevering.dto;

import com.natsuki_kining.persevering.beans.PlanVO;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 0:32
 **/
@Data
public abstract class PlanDTO {

    protected PlanVO planVO;

    protected String fileName;

    protected String title;

    protected String templateFilePath;

    protected Map<String, String> data;

    public PlanDTO(){
        data = new HashMap<>();
    }
}
