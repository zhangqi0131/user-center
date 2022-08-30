package com.zhangqi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月30日 16:31  周二
 */
@Data
public class TeamJoinRequest implements Serializable {


    private static final long serialVersionUID = -9166613814453502695L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 队伍密码
     */
    private String password;
}
