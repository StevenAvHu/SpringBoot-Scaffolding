package com.api.library;

import com.common.result.APIResult;
import com.request.library.UserLoginRequest;
import com.service.library.UserLoginSevice;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @program: springCloud
 * @description: 用户登录API
 * @author: 胡宇鑫
 * @create: 2022-04-05 10:31
 **/
@RestController
@RequestMapping("api")
@Slf4j
@Api(value = "用户登录")
public class UserLoginApi {
    /**
     * 用户登录sevice
     */
    @Resource
    private UserLoginSevice userLoginSevice;

    /**
     *  用户登录api
     * @param request request
     * @param session session
     * @return APIResult
     */
    @PostMapping(value = "/login")
    public APIResult login(@RequestBody @Valid UserLoginRequest request, HttpSession session){
        return userLoginSevice.login(request,session);
    }
    @GetMapping(value = "test")
    public String test(){
        return "111";
    }

}
