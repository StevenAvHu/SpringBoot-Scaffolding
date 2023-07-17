package com.entity.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: springCloud
 * @description: 用户类
 * @author: 胡宇鑫
 * @create: 2022-04-05 10:44
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
}
