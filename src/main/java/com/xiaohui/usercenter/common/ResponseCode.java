package com.xiaohui.usercenter.common;

/**
 * 作者:灰爪哇
 * 时间:2024-02-22
 */
public enum ResponseCode {

    SUCCESS(200, "成功"),

    FAIL(500, "失败"),

    NULL_PARAMETER(502, "失败"),

    PARAMETER_ERROR(503, "失败"),

    UNAUTHORIZED(401, "未授权"),

    FORBIDDEN(403, "禁止"),

    NOT_FOUND(404, "未找到"),

    METHOD_NOT_ALLOWED(405, "方法不被允许"),

    INTERNAL_SERVER_ERROR(501, "服务器内部错误"),

    UNPROCESSABLE_ENTITY(422, "请求实体无法处理");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }



    public int getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }
}
