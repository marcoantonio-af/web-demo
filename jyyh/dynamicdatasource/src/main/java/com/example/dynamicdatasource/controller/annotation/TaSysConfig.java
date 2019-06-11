package com.example.dynamicdatasource.controller.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TaSysConfig {

    /**
     * 字段名称
     * @return 字段名称
     */
    String fieldName();

    /**
     * 默认值
     * @return 默认值
     */
    String defaultValue() default "";

    /**
     * 默认数据类型：text，类型包括（text,date,selectInput,number)
     * @return 数据类型
     */
    TaDataTypeEnum dataType() default TaDataTypeEnum.TEXT;

    /**
     * 所属配置区域：默认系统配置
     * @return 所属配置区域
     */
    TaFunctionTypeEnum functionType() default TaFunctionTypeEnum.SYSTEMCONFIG;

    /**
     * 如果propertyType=TaDataTypeEnum.SELECTINPUT,则需要设置码值，例如orgType，如果设置了collectionDatas，以collectionDatas为准
     * @return 码表类型
     */
    String collectionName() default "";

    /**
     * 如果propertyType=TaDataTypeEnum.SELECTINPUT，则需要设置码值，例如[{"id":"1","name":"男"},{"id":"2","name":"女"}]
     * @return 码表值
     */
    String collectionDatas() default "";
}
