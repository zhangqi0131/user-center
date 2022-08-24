package com.zhangqi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @Description 通用的分页请求参数
 * @createTime 2022年08月23日 16:27  周二
 */
@Data
public class PageRequest implements Serializable {


    private static final long serialVersionUID = 7094072656236498884L;
    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;



}
