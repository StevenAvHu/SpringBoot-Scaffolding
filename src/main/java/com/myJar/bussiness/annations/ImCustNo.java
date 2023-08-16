package com.myJar.bussiness.annations;


import java.lang.annotation.*;

/**
 * @program: springCloud
 * @description: 客户号代码注解
 * @author: 胡宇鑫
 * @create: 2023-07-27 17:00
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ImCustNo {
}
