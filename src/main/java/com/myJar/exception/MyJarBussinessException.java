package com.myJar.exception;

/**
 * @author 胡宇鑫
 * @date 2023/7/18 13:41
 * @description 自定义异常
 */
public class MyJarBussinessException extends RuntimeException {
    /**
     * 返回码值 默认0001异常
     */
    protected String retCode = "0001";
    /**
     * 返回数据
     */
    protected transient Object data;

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param retCode 响应码值
     */
    public MyJarBussinessException(String message, String retCode) {
        super(message);
        this.retCode = retCode;
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     * @param data    返回数据
     */
    public MyJarBussinessException(String message, Object data) {
        super(message);
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param message 异常信息
     */
    public MyJarBussinessException(String message) {
        super(message);
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
