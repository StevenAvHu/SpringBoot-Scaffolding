package com.myJar.bussiness.bean;

import com.myJar.bussiness.annations.CheckUser;
import com.myJar.exception.MyJarBussinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 胡宇鑫
 * @date 2023/7/17 15:07
 * @description 数据读取Aspect
 */
@Aspect
@Component
@Slf4j
public class CheckCommandAspect {
    private CheckService checkService;

    @Autowired
    public CheckCommandAspect(CheckService checkService) {
        this.checkService = checkService;
    }

    @Pointcut("@annotation(com.myJar.bussiness.annations.CheckUser)")
    public void checkUser() {
        //aop do nothing
    }


    @Before("checkUser()")
    public void checkUser(JoinPoint joinPoint) throws MyJarBussinessException {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CheckUser checkUser = method.getAnnotation(CheckUser.class);
        checkService.checkUserRole(joinPoint.getArgs()[checkUser.paramIndex()], checkUser.roleType());
    }
}
