package com.zhangqi.usercenter.model.dto;

import com.zhangqi.usercenter.model.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author ZhangQi
 * @Description 队伍查询封装类
 * @createTime 2022年08月23日 16:09  周二
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeamQuery extends PageRequest {
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

}
