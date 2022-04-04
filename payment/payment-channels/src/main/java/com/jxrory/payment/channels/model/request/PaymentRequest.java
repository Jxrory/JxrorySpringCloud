package com.jxrory.payment.channels.model.request;

import com.jxrory.common.entity.AmountEntity;
import com.jxrory.payment.model.request.CustomerInfo;
import lombok.Data;

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
    private String orderId;

    /**
     * 金额
     */
    private AmountEntity amount;

    /**
     * 备注
     */
    private String comment;

    /**
     * 渠道扩展数据, json 格式字符串
     */
    private String channelExt = "";

    /**
     * 回调 URL
     */
    private String callbackUrl;

    /**
     * 客户信息
     */
    private CustomerInfo customer;
}
