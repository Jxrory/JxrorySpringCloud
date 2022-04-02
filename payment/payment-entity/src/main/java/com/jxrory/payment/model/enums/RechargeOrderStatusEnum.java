package com.jxrory.payment.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 充值订单状态
 *
 * @author Rory
 * @date 2022/03/27
 */
@Getter
public enum RechargeOrderStatusEnum {
    // 订单创建成功
    CREATED(0, "订单创建成功"),
    SUCCESS(1, "支付成功"),
    FAILED(2, "支付失败"),
    WAITING(3, "支付中"),
    ;

    @EnumValue
    private int code;

    private String detail;

    RechargeOrderStatusEnum(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }
}
