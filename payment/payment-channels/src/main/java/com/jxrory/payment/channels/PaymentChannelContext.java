package com.jxrory.payment.channels;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 支付渠道匹配
 *
 * @author Rory
 * @date 2022/03/24
 */
@Component
public class PaymentChannelContext {

    @Resource
    private Map<String, PaymentService> paymentServices;

    @Resource
    private Map<String, TransfersService> transfersServices;

    public PaymentService getPaymentService(String channelName) {
        return paymentServices.get(channelName + "-payment");
    }

    public TransfersService getTransferService(String channelName) {
        return transfersServices.get(channelName + "-transfer");
    }
}
