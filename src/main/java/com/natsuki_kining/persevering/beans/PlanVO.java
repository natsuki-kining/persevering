package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.enums.PlanType;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 计划表
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 17:50
 */
@Data
public class PlanVO extends BaseEntity {

    private String name;
    private PlanType type;
    private List<PlanItem> items;

    /**
     * 计划时间
     */
    private String planTime;

    public String getNotBlankType(){
        return getNotBlank(this.type.getName());
    }

    public String getNotBlankPlanTime(){
        return getNotBlank(this.planTime);
    }

    public String getNotBlank(String str){
        if (StringUtils.isBlank(str)){
            return "";
        }
        return "-"+str;
    }

}
