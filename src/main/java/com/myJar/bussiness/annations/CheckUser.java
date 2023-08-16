package com.myJar.bussiness.annations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 胡宇鑫
 * @date 2023/7/17 11:00
 * @description 校验用户
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckUser {
    /**
     * 方法第几个参数
     *
     * @return int
     */
    int paramIndex() default 0;

    /**
     * 角色类型
     *
     * @return string
     */
    String roleType();
}
