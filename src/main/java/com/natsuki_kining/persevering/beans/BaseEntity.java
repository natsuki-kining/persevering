package com.natsuki_kining.persevering.beans;

import com.natsuki_kining.persevering.constant.PerseveringConstant;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO
 *
 * @Author natsuki_kining
 * @Date 2021/3/28 16:52
 **/
@Data
public abstract class BaseEntity {

    private String defaultPlanItem;
    private Integer defaultPlanItemTotal;

    public String getDefaultPlayItem() {
        if (StringUtils.isBlank(this.defaultPlanItem)) {
            defaultPlanItem = PerseveringConstant.DEFAULT_PLAN_ITEM;
        }
        return defaultPlanItem;
    }

    public Integer getDefaultPlanItemTotal() {
        if (defaultPlanItemTotal == 0) {
            defaultPlanItemTotal = PerseveringConstant.DEFAULT_PLAN_ITEM_TOTAL;
        }
        return defaultPlanItemTotal;
    }
}
