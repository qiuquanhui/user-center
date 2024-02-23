package com.xiaohui.usercenter.common;/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */

/**
 *
 *
 * @author: Hui
 **/
public class Result {

    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<T>(200,"success",data);
    }

    public static <T> BaseResponse<T> success(){
        return new BaseResponse<T>(200,"success",null);
    }

    public static <T> BaseResponse<T> success(String msg){
        return new BaseResponse<T>(200,msg,null);
    }

    public static <T> BaseResponse<T> success(String msg,T data){
        return new BaseResponse<T>(200,msg,data);
    }

    public static <T> BaseResponse<T> error(){
        return new BaseResponse<T>(500,"error");
    }

    public static <T> BaseResponse<T> error(String msg){
        return new BaseResponse<T>(500,msg);
    }

    public static <T> BaseResponse<T> error(int code,String msg){
        return new BaseResponse<T>(code,msg);
    }


}
