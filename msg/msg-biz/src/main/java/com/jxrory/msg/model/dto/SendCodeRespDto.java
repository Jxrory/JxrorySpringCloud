package com.jxrory.msg.model.dto;

import com.jxrory.common.api.IErrorCode;
import lombok.Data;

/**
 * 发送验证码返回值
 *
 * @author Rory
 * @date 2022/03/02
 */
@Data
public class SendCodeRespDto {

    /**
     * 错误码
     */
    private IErrorCode errorCode;

    /**
     * 三方返回值
     */
    private String resp;

    public SendCodeRespDto() {
    }

    public SendCodeRespDto(IErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
