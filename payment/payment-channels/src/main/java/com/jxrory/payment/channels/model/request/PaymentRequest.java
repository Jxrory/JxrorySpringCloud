package com.jxrory.payment.channels.model.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 收款请求参数
 *
 * @author Rory
 * @date 2022/03/26
 */
@Data
public class PaymentRequest {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 币种(ISO-4217 Code)
     */
    private String currency;

    /**
     * 金额, 币种的基础单位(元)
     */
    private BigDecimal amount;

    /**
     * 回调 URL
     */
    private String callbackUrl;
}
