package com.natsuki_kining.persevering.converter.handle;

import com.natsuki_kining.persevering.converter.ConverterEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author natsuki_kining
 */
@MappedTypes({ConverterEnum.class})
public class ConverterEnumHandler extends ConverterEnumTypeHandler<ConverterEnum> {
    public ConverterEnumHandler(Class<ConverterEnum> enumType) {
        super(enumType);
    }
}