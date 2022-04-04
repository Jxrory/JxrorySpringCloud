package com.jxrory.payment.channels.model.enums;

import lombok.Getter;

/**
 * 订单状态
 *
 * @author Rory
 * @date 2022/04/04
 */
@Getter
public enum OrderStatusEnum {
    // 已创建
    CREATED("已创建"),
    // 待支付
    PENDING("待支付"),
    // 成功
    SUCCESS("成功"),
    // 失败
    FAILED("失败"),
    // 废单
    ABANDONED("废单"),
    ;

    private String detail;

    OrderStatusEnum(String detail) {
        this.detail = detail;
    }
}
