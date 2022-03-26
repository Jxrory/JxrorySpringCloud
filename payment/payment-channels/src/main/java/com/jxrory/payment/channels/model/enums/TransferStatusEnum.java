package com.jxrory.payment.channels.model.enums;

import lombok.Getter;

/**
 * 划转结果状态
 *
 * @author Rory
 * @date 2022/03/26
 */
@Getter
public enum TransferStatusEnum {
    // 订单创建成功
    CREATED("创建成功"),
    SUCCESS("转账成功"),
    FAILED("转账失败"),
    ;

    /**
     * 详细描述
     */
    private String detail;

    TransferStatusEnum(String detail) {
        this.detail = detail;
    }
}
