package com.myJar.bussiness.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springCloud
 * @description: 配置
 * @author: 胡宇鑫
 * @create: 2023-07-31 11:13
 **/
@Component
@ConfigurationProperties(prefix = "com.myjar.config")
public class ConfigProperties {


    /**
     * 客户信息表
     */
    private String custInfoTableName = "cust_info";

    public String getCustInfoTableName() {
        return custInfoTableName;
    }

    public void setCustInfoTableName(String custInfoTableName) {
        this.custInfoTableName = custInfoTableName;
    }
}
