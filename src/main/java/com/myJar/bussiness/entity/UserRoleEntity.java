package com.myJar.bussiness.entity;

import lombok.Data;

/**
 * @program: springCloud
 * @description: 用户信息实体
 * @author: 胡宇鑫
 * @create: 2023-08-16 10:51
 **/
@Data
public class UserRoleEntity {
    /**
     * 客户号
     */
    private String imCustNo;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 角色类型
     */
    private String roleType;
}
