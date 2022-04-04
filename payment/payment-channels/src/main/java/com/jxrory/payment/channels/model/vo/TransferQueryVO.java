package com.jxrory.payment.channels.model.vo;

import com.jxrory.common.api.IErrorCode;
import com.jxrory.payment.channels.model.enums.OrderStatusEnum;
import lombok.Data;

/**
 * 支付订单查询返回结果
 *
 * @author Rory
 * @date 2022/04/04
 */
@Data
public class TransferQueryVO {

    /**
     * 订单状态
     */
    private OrderStatusEnum status;

    /**
     * 系统内部的错误信息
     */
    private IErrorCode errorCode;

    /**
     * 支付三方的错误信息
     */
    private IErrorCode thirdErrorCode;

    /**
     * 订单 Id
     */
    private String orderId;

    /**
     * 返回值
     */
    private String originalResp;
}
