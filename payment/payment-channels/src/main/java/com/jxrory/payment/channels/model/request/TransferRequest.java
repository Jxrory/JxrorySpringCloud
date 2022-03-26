package com.jxrory.payment.channels.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Rory
 * @date 2022/03/26
 */
@Data
public class TransferRequest {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 币种(ISO-4217 Code)
     */
    private String currency;

    /**
     * 提现金额
     */
    private BigDecimal amount;

    /**
     * 收款人信息
     * 包括用户名字, 联系方式, 银行账户, 等信息
     */
    private Object to;

    /**
     * 扩展数据
     */
    private Object metaData;

    /**
     * 转账备注
     */
    private String comment;

    /**
     * 订单创建时间
     */
    private Date created;
}
