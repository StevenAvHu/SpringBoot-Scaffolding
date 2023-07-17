package com.service.library;

import com.common.exception.BusinessException;
import com.common.result.APIResult;
import com.domain.library.UserLoginDomain;
import com.request.library.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @program: springCloud
 * @description: 用户登录Service
 * @author: 胡宇鑫
 * @create: 2022-04-05 10:43
 **/
@Service
@Slf4j
public class UserLoginSevice {
    /**
     * UserLoginDomain
     */
    @Resource
    private UserLoginDomain userLoginDomain;

    /**
     * 用户登录
     *
     * @param request request
     * @param session session
     * @return APIResult
     */
    public APIResult login(UserLoginRequest request, HttpSession session) {
        try {
            boolean result = userLoginDomain.login(request, session);
            if (result) {
                return APIResult.success("登录成功");
            } else {
                return APIResult.failure("登录失败");
            }
        } catch (Exception e) {
            log.error("用户登录出错：", e);
            throw new BusinessException("用户登录出错：", e);
        }
    }

}
