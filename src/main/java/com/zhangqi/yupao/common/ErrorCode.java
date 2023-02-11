package com.zhangqi.yupao.common;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description
 * @createTime 2022年08月02日 16:02  周二
 */
public enum ErrorCode {

    /**
     * 错误代码
     */
    SUCCESS(0, "成功", ""),
    PARAMS_ERROR(40000, "请求参数错误", ""),
    NULL_ERROR(40001, "数据为空", ""),
    NOT_LOGIN(40100, "未登录", ""),
    NO_AUTH(40101, "无权限", ""),
    FORBIDDEN(40301, "禁止操作", ""),
    SYSTEM_ERROR(50000, "系统内部异常", "");


    private final int code;

    /**
     * 状态码信息
     */
    private final String message;
    /**
     * 状态码详情
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
