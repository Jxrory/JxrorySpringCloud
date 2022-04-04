package com.jxrory.payment.channels;


import com.jxrory.common.exception.BizException;
import com.jxrory.payment.channels.model.ChannelResult;
import com.jxrory.payment.channels.model.request.PaymentRequest;
import com.jxrory.payment.channels.model.vo.PaymentQueryVO;
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
     * 支付前置校验, 参数校验等
     *
     * @param paymentOrder 请求参数
     * @return true | false
     * @throws BizException 校验异常
     */
    Boolean preCheck(PaymentRequest paymentOrder) throws BizException;

    /**
     * 初始化收款数据
     *
     * @param paymentOrder 收款请求参数 {@link PaymentRequest}
     * @return {@link ChannelResult<PaymentVO>}
     */
    ChannelResult<PaymentVO> initPayment(PaymentRequest paymentOrder);

    /**
     * 查询单笔订单信息
     *
     * @param orderId 订单号
     * @return {@link PaymentQueryVO}
     */
    PaymentQueryVO queryPaymentOrder(String orderId);

    /**
     * 解析回调数据
     *
     * @param orderInfo 订单信息
     * @return {@link PaymentQueryVO}
     */
    PaymentQueryVO paymentCallbackParser(String orderInfo);
}
