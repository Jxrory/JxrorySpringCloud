package com.jxrory.payment.channels;

import com.jxrory.payment.channels.model.ChannelResult;
import com.jxrory.payment.channels.model.request.TransferRequest;
import com.jxrory.payment.channels.model.vo.TransferVO;

/**
 * 给用户打款(转账)
 * <p>
 * 包含在其中的流程:
 * 1. 提现
 *
 * @author Rory
 * @date 2022/03/26
 */
public interface TransfersService {

    /**
     * 前置检查
     *
     * @param transferRequest 订单信息
     * @return {@link ChannelResult<Object>}
     */
    ChannelResult<Object> preCheck(TransferRequest transferRequest);

    /**
     * 划转
     *
     * @param transferRequest 划转请求参数
     * @param checkResp       前置检查返回的结果
     * @return res 划转结果
     */
    ChannelResult<TransferVO> transfer(TransferRequest transferRequest, ChannelResult<Object> checkResp);

    // 查询
    void queryTransferOrder();

    // 回调解析器
    void transfersCallbackParser();
}
