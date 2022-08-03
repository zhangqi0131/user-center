package com.zhangqi.usercenter.exception;

import com.zhangqi.usercenter.common.BaseResponse;
import com.zhangqi.usercenter.common.ErrorCode;
import com.zhangqi.usercenter.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description 全局异常处理器
 *              Spring AOP：在调用方法前后进行额外的处理
 * @createTime 2022年08月02日 16:37  周二
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessExceptionHandler(BusinessException e) {
        log.error("businessException:" + e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    /**
     * 项目中出现的runtimeException都会被记录下来
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse RuntimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException:" + e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }
}
