package com.jxrory.common.api;

import lombok.Getter;

/**
 * 通用错误码
 *
 * @author Rory
 * @date 2022/02/25
 */
@Getter
public enum CommonErrorCode implements IErrorCode {
    // 成功
    OK("000000", "OK"),

    /**
     * 错误
     */
    // 参数校验异常
    PARAMS_FAILED("E00001", "Parameter validation failed"),
    // 网络异常
    NETWORK_ERR("E00002", "Network error"),

    // 未知错误
    FAILED("E99999", "FAILED"),
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

    CommonErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static boolean isOk(IErrorCode errorCode) {
        return OK.getCode().equals(errorCode.getCode());
    }
}
