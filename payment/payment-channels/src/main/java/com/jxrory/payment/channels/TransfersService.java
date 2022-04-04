package com.jxrory.payment.channels;

import com.jxrory.common.exception.BizException;
import com.jxrory.payment.channels.model.ChannelResult;
import com.jxrory.payment.channels.model.request.TransferRequest;
import com.jxrory.payment.channels.model.vo.TransferQueryVO;

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
     * 转账前置校验
     *
     * @param transferRequest 转账请求
     * @return true | false
     * @throws BizException 检查异常可以抛出 {@link BizException} 异常
     */
    Boolean preCheck(TransferRequest transferRequest) throws BizException;

    /**
     * 预转账处理, 可以返回异常, 代表划转失败
     *
     * @param transferRequest 订单信息
     * @return {@link ChannelResult<Object>}
     * @throws BizException 检查异常可以抛出 {@link BizException} 异常
     */
    ChannelResult<Object> preTransfer(TransferRequest transferRequest) throws BizException;

    /**
     * 划转
     *
     * @param transferRequest 划转请求参数
     * @param preTransferResp 前置检查返回的结果
     * @return 划转结果
     */
    ChannelResult<Object> transfer(TransferRequest transferRequest, ChannelResult<Object> preTransferResp);

    /**
     * 查询
     *
     * @param orderNo 订单号
     * @return {@link TransferQueryVO}
     */
    TransferQueryVO queryTransferOrder(String orderNo);

    /**
     * 回调解析器
     *
     * @param orderInfo 订单信息
     * @return {@link TransferQueryVO}
     */
    TransferQueryVO transfersCallbackParser(String orderInfo);
}
