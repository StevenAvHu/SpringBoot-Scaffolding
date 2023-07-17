package com.common.exception;

import lombok.Data;

/**
 * @program: springCloud
 * @description: 自定义异常类
 * @author: 胡宇鑫
 * @create: 2022-04-02 09:01
 **/
@Data
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = -12313L;
    /**
     * 异常编码
     */
    protected String retCode = "0001";
    /**
     * 调用参数
     */
    protected transient Object data;
    /**
     * 原始异常
     */
    protected Throwable origin;

    /**
     * 构造函数
     * @param message 异常信息
     */
    public BusinessException(String message){
        super(message);
    }

    /**
     * 构造函数
     * @param message 异常信息
     * @param data 调用参数
     */
    public BusinessException(String message,Object data){
        super(message);
        this.data = data;
    }

}
