package com.zhangqi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description 用户登录请求体
 * @createTime 2022年03月20日 15:32  周日
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = 4939044841262932472L;

    private String userAccount;

    private String userPassword;
}
