package com.domain.library;

import com.domain.repository.library.UserLoginRepository;
import com.entity.library.UserEntity;
import com.request.library.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @program: springCloud
 * @description: UserLoginDomain
 * @author: 胡宇鑫
 * @create: 2022-04-05 10:44
 **/
@Service
@Slf4j
public class UserLoginDomain {
    /**
     * UserLoginRepository
     */
    @Resource
    private UserLoginRepository userLoginRepository;

    /**
     * 用户登录校验
     *
     * @param userLoginRequest userLoginRequest
     * @param session          session
     * @return boolean
     */
    public boolean login(UserLoginRequest userLoginRequest, HttpSession session) {
        UserEntity entity = userLoginRepository.queryUserInformation(userLoginRequest.getUsername(), userLoginRequest.getPassword());
        if (entity != null) {
            session.setAttribute("user", entity);
            return true;
        } else {
            return false;
        }
    }


}
