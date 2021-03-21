package com.natsuki_kining.persevering.converter.handle;

import com.natsuki_kining.persevering.converter.ConverterEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 保存到数据库需要实现和数据库的自定义转换类,否则向数据库添加数据的时候会报类型转换错误,无法添加数据
 *
 * @Author natsuki_kining
 * @Date 2021/3/21 17:11
 **/
@MappedTypes({ConverterEnum.class})
@MappedJdbcTypes({JdbcType.INTEGER})
public class ConverterEnumTypeHandler<E extends ConverterEnum> extends BaseTypeHandler<ConverterEnum> {
    private Class<E> clazz;

    public ConverterEnumTypeHandler(Class<E> enumType) {
        if (enumType == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.clazz = enumType;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, ConverterEnum windLabEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, windLabEnum.getValue());
    }

    @Override
    public ConverterEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getByType(resultSet.getInt(s));
    }

    @Override
    public ConverterEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getByType(resultSet.getInt(i));
    }

    @Override
    public ConverterEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getByType(callableStatement.getInt(i));
    }

    private ConverterEnum getByType(int anInt) {
        final E[] enumConstants = clazz.getEnumConstants();
        for (ConverterEnum enums : enumConstants) {
            if (enums.getValue() == anInt) {
                return enums;
            }
        }
        return null;
    }
}