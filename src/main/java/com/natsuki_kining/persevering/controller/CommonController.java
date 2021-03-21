package com.natsuki_kining.persevering.controller;

import com.natsuki_kining.persevering.PerseveringConfig;
import com.natsuki_kining.persevering.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/21 16:10
 **/
@RestController
public class CommonController {

    @Autowired
    private PerseveringConfig config;

    @PostMapping("getBasicData")
    public Map<String,Object> getBasicData(){
        //判断是否连数据库
        return getEnums();
    }

    private Map<String,Object> getEnums(){
        Map<String,Object> map = new HashMap<>();
        map.put("hourPeriods",HourPeriods.values());
        map.put("planItemType", PlanItemType.values());
        map.put("planItemWeight", PlanItemWeight.values());
        map.put("planType", PlanType.values());
        map.put("timeQuantum", TimeQuantum.values());

        return map;
    }

    private Map<String,Object> getList(){
        Map<String,Object> map = new HashMap<>();
        //加载数据库

        return map;
    }
}
