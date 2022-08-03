package com.zhangqi.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description 通用返回类
 * @createTime 2022年08月02日 15:42  周二
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    private String description;

    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null, errorCode.getMessage(), errorCode.getDescription());
    }








}
