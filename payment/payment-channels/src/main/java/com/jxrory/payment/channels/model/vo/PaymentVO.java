package com.jxrory.payment.channels.model.vo;

import lombok.Data;

/**
 * @author Rory
 * @date 2022/03/23
 */
@Data
public class PaymentVO {

    /**
     * 唯一订单号
     */
    private String orderId;

    /**
     * 支付 token
     */
    private String payToken;
}
