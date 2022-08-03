package com.zhangqi.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description 用户注册请求体
 * @createTime 2022年03月20日 15:21  周日
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -1461034967695318690L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;

}
