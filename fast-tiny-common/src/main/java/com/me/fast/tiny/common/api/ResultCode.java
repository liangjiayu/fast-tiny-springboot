package com.me.fast.tiny.common.api;

import lombok.Getter;

@Getter
public enum ResultCode implements IErrorCode {
    SUCCESS(0, "请求成功"),
    FAILED(500, "服务器内部错误"),
    PARAMETER_ERROR(400, "请求参数错误"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}

