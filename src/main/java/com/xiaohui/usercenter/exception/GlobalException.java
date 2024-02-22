package com.xiaohui.usercenter.exception;/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */

import com.xiaohui.usercenter.common.BaseResponse;
import com.xiaohui.usercenter.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 *
 * @author: Hui
 **/
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse handlerBusinessException(BusinessException e) {
        log.error("BusinessException", e);
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse handlerException(RuntimeException e) {
        log.error("Exception", e);
        return Result.error();
    }
}
