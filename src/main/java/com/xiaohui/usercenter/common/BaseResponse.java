package com.xiaohui.usercenter.common;/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author: Hui
 **/
@Getter
@Setter
public class BaseResponse<T> {

    private int code;
    private String msg;
    private T data;

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



}
