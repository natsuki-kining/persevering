package com.natsuki_kining.persevering.config;

import com.natsuki_kining.persevering.enums.PlanItemType;
import lombok.Data;

import java.util.List;

/**
 * Excel配置类
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/26 22:42
 */
@Data
public class ExcelSetting {

    /**
     * 是否合并单元格
     */
    private boolean merge;

    /**
     * 需要移除的计划项，不需要通过Excel导出。
     */
    private List<PlanItemType> removeItemType;
}
