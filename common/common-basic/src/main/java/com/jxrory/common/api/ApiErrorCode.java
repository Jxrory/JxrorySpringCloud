package com.jxrory.common.api;

import lombok.Getter;

/**
 * 通用错误码
 *
 * @author Rory
 * @date 2022/02/25
 */
@Getter
public enum ApiErrorCode implements IErrorCode {
    // 成功
    OK("000000", "OK"),

    /**
     * 错误
     */
    // 未知错误
    FAILED("E00000", "FAILED"),
    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    ApiErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static boolean isOk(IErrorCode errorCode) {
        return OK.getCode().equals(errorCode.getCode());
    }
}
