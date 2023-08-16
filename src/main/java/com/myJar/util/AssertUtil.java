package com.myJar.util;

import com.myJar.exception.MyJarBussinessException;
import org.springframework.util.StringUtils;

/**
 * @program: springCloud
 * @description: 校验工具类
 * @author: 胡宇鑫
 * @create: 2023-08-16 11:13
 **/
public class AssertUtil {
    /**
     * 若不为真，则抛出指定内容的异常信息
     *
     * @param expression 表达式
     * @param message    异常信息
     * @throws MyJarBussinessException
     */
    public static void isTrue(boolean expression, String message) throws MyJarBussinessException {
        if (!expression) {
            throw new MyJarBussinessException(message);
        }
    }

    /**
     * 若为真，则抛出指定内容异常
     *
     * @param expression 表达式
     * @param message    异常信息
     * @throws MyJarBussinessException
     */
    public static void notTrue(boolean expression, String message) throws MyJarBussinessException {
        if (expression) {
            throw new MyJarBussinessException(message);
        }
    }

    /**
     * 若为空，则抛出制定内容
     *
     * @param expression 表达式
     * @param message    异常信息
     * @throws MyJarBussinessException
     */
    public static void notNull(Object expression, String message) throws MyJarBussinessException {
        if (StringUtils.isEmpty(expression)) {
            throw new MyJarBussinessException(message);
        }
    }
}
