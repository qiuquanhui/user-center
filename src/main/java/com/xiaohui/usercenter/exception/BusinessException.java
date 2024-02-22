package com.xiaohui.usercenter.exception;/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */

import com.xiaohui.usercenter.common.ResponseCode;
import lombok.Getter;

/**
 *
 *
 * @author: Hui
 **/
@Getter
public class BusinessException extends RuntimeException{

    private int code;

    private String description;

    public BusinessException(int code, String message,String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
        this.description = responseCode.getMsg();
    }


}
