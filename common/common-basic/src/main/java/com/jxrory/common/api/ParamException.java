package com.jxrory.common.api;

import lombok.Getter;

/**
 * 参数异常, 给前端的状态码为: 400
 *
 * @author Rory
 * @date 2022/02/25
 */
@Getter
public class ParamException extends RuntimeException {

    private String code;

    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ParamException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }
}
