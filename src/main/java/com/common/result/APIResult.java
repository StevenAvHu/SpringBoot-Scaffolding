package com.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: springCloud
 * @description: 公共返回体
 * @author: 胡宇鑫
 * @create: 2022-03-30 11:00
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResult<T> implements Serializable {
    private static final long SerialVersionUID = 2L;
    /**
     * 状态标识：1-成功、0-失败
     */
    private Integer flag;
    /**
     * 返回码
     */
    private String retCode;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 数据
     */
    private transient T data;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 成功
     */
    private static final Integer SUCCESS = 1;
    /**
     * 失败
     */
    private static final Integer FAILURE = 0;

    /**
     * 成功
     */
    private static final String SUCCESS_CODE = "0001";
    /**
     * 失败
     */
    private static final String FAILURE_CODE = "0000";

    /**
     *  成功返回信息（没有数据的情况）
     * @param retCode 返回码
     * @param message 返回信息
     * @return APIResult
     */
    public static APIResult success(String retCode,String message){
        return APIResult.builder()
                .retCode(retCode)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .flag(SUCCESS)
                .build();
    }

    /**
     *  成功返回信息（有数据的情况）
     * @param message 返回信息
     * @param data 返回数据
     * @return APIResult
     */
    public static <T>APIResult success(String message,T data){
        return APIResult.builder()
                .retCode(SUCCESS_CODE)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .data(data)
                .flag(SUCCESS)
                .build();
    }

    /**
     *  成功返回信息（仅有数据的情况）
     * @param data 返回数据
     * @return APIResult
     */
    public static <T>APIResult success(T data){
        return APIResult.builder()
                .retCode(SUCCESS_CODE)
                .timestamp(System.currentTimeMillis())
                .data(data)
                .flag(SUCCESS)
                .build();
    }

    /**
     *  成功返回信息（仅有信息）
     * @param message 返回信息
     * @return APIResult
     */
    public static APIResult success(String message){
        return APIResult.builder()
                .retCode(SUCCESS_CODE)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .flag(SUCCESS)
                .build();
    }

    /**
     *  失败返回信息（没有数据的情况）
     * @param retCode 返回码
     * @param message 返回信息
     * @return APIResult
     */
    public static APIResult failure(String retCode,String message){
        return APIResult.builder()
                .retCode(retCode)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .flag(FAILURE)
                .build();
    }

    /**
     *  失败返回信息（有数据的情况）
     * @param message 返回信息
     * @param data 返回数据
     * @return APIResult
     */
    public static <T>APIResult failure(String message,T data){
        return APIResult.builder()
                .retCode(FAILURE_CODE)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .data(data)
                .flag(FAILURE)
                .build();
    }

    /**
     *  失败返回信息（仅有数据的情况）
     * @param data 返回数据
     * @return APIResult
     */
    public static <T>APIResult failure(T data){
        return APIResult.builder()
                .retCode(FAILURE_CODE)
                .timestamp(System.currentTimeMillis())
                .data(data)
                .flag(FAILURE)
                .build();
    }
    /**
     *  失败返回信息（仅有信息）
     * @param message 返回信息
     * @return APIResult
     */
    public static APIResult failure(String message){
        return APIResult.builder()
                .retCode(FAILURE_CODE)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .flag(FAILURE)
                .build();
    }

}
