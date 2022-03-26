package com.jxrory.payment.channels;


import com.jxrory.payment.channels.model.ChannelResult;
import com.jxrory.payment.channels.model.request.PaymentRequest;
import com.jxrory.payment.channels.model.vo.PaymentVO;

/**
 * 收款
 * <p>
 * 包含在其中的流程:
 * 1. 充值;
 *
 * @author Rory
 * @date 2022/03/26
 */
public interface PaymentService {

    /**
     * 初始化收款数据
     *
     * @param requestParams 收款请求参数 {@link PaymentRequest}
     * @return {@link PaymentVO}
     */
    ChannelResult<PaymentVO> initPayment(PaymentRequest requestParams);

    // 查询单笔订单信息 TODO(jx)
    void queryPaymentOrder(String orderId);

    // 解析回调数据 TODO(jx)
    void paymentCallbackParser();
}
