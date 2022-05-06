package com.jxrory.components.oss.exception;

import com.jxrory.common.api.IErrorCode;
import lombok.Getter;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Getter
public enum OssErrorCode implements IErrorCode {
    // 阿里云配置错误
    ALI_OSS_CONFIG_ERROR("OSS101", "阿里云配置错误, 请检查相关配置"),
    ALI_OSS_INIT_FAILED("OSS102", "阿里云初始化失败"),
    ;

    private String code;

    private String message;

    OssErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.message;
    }
}
