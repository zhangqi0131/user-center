package com.zhangqi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年09月18日 13:21  周日
 */
@Data
public class TeamQuitRequest implements Serializable {


    private static final long serialVersionUID = -8599770422227720863L;

    private Long teamId;
}
