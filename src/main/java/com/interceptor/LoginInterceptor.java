package com.interceptor;

import com.entity.library.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: springCloud
 * @description: 后端拦截器
 * @author: 胡宇鑫
 * @create: 2022-04-06 18:57
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };

        String uri = httpServletRequest.getRequestURI();

        uri = StringUtils.remove(uri, contextPath + "/");
        String page = uri;

        if (begingWith(page, requireAuthPages)) {
            UserEntity user = (UserEntity) session.getAttribute("user");
            if (user == null) {
                httpServletResponse.sendRedirect("api/login");
                return false;
            }
        }
        return true;
    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if (StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }


}
