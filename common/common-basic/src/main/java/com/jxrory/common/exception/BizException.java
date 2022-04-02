package com.jxrory.common.exception;

import com.jxrory.common.api.IErrorCode;
import lombok.Getter;

/**
 * 业务统一异常类
 *
 * @author Rory
 * @date 2022/02/25
 */
@Getter
public class BizException extends RuntimeException {

    /**
     * HTTP 状态码
     */
    private int status = 500;

    /**
     * 错误码
     */
    private String code;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
    }
}
