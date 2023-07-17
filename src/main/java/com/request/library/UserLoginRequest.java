package com.request.library;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @program: springCloud
 * @description: 登录请求体
 * @author: 胡宇鑫
 * @create: 2022-04-05 10:34
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLoginRequest {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    String password;
}
