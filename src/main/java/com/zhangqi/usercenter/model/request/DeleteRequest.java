package com.zhangqi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangQi
 * @Description General delete request parameters
 * @createTime 2022年09月22日 14:34  周四
 */
@Data
public class DeleteRequest implements Serializable {


    private static final long serialVersionUID = -4152220012598383522L;

    private Long id;

}
