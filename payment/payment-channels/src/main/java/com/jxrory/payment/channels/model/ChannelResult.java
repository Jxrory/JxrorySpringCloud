package com.jxrory.payment.channels.model;

import com.jxrory.common.api.CommonErrorCode;
import com.jxrory.common.api.IErrorCode;
import lombok.Data;

/**
 * 请求渠道返回结果
 *
 * @author Rory
 * @date 2022/03/26
 */
@Data
public class ChannelResult<T> {

    /**
     * 错误码
     */
    private IErrorCode errorCode;

    /**
     * 数据
     */
    private T data;

    /**
     * 原始请求返回的数据
     */
    private String originalResp;

    public ChannelResult<T> ok(T data, String originalResp) {
        this.errorCode = CommonErrorCode.OK;
        this.data = data;
        this.originalResp = originalResp;
        return this;
    }

    public ChannelResult<T> failed(String originalResp) {
        this.errorCode = CommonErrorCode.FAILED;
        this.originalResp = originalResp;
        return this;
    }
}
