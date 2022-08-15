package com.zhangqi.usercenter.script;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 星球表哥用户信息
 * @author zhangqi
 */
@Data
public class PlanetTableUserInfo {

    /**
     * id
     */
    @ExcelProperty("成员编号")
    private String planetCode;

    /**
     * 用户昵称
     */
    @ExcelProperty("成员昵称")
    private String username;


}