package com.jxrory.payment.channels.model.request;

import com.jxrory.common.entity.AmountEntity;
import com.jxrory.payment.model.request.RecipientInfo;
import lombok.Data;

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
    private String orderNo;

    /**
     * 金额
     */
    private AmountEntity amount;

    /**
     * 收款人信息
     * 包括用户名字, 联系方式, 银行账户, 等信息
     */
    private RecipientInfo recipient;

    /**
     * 转账备注
     */
    private String comment;

    /**
     * 订单创建时间
     */
    private Date created;
}
