package com.jxrory.payment.model.request;

import com.jxrory.common.entity.AmountEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 充值请求参数:
 * 什么人以什么样的方式充值多少金额.
 *
 * @author Rory
 * @date 2022/03/27
 */
@Data
@ApiModel(description = "充值请求参数", value = "充值请求参数")
public class RechargeRequest {

    @ApiModelProperty(name = "mchOrderNo", required = true, value = "订单号", example = "Order_000000001")
    @NotBlank
    private String mchOrderNo;


    /**
     * 客户信息
     */
    @ApiModelProperty(name = "customer", required = true, value = "客户信息")
    private CustomerInfo customer;


    /**
     * 充值的方式或渠道
     */
    @ApiModelProperty(name = "channel", required = true, value = "支付方式", example = "WX-H5")
    private String channel;

    /**
     * 充值金额
     */
    @ApiModelProperty(name = "amount", required = true, value = "充值金额")
    @NotNull
    private AmountEntity amount;


    /**
     * 其它
     */
    @ApiModelProperty(name = "comment", value = "备注, 默认: Recharge", example = "Recharge")
    private String comment = "Recharge";

    @ApiModelProperty(name = "channelExt", value = "渠道扩展数据, json 格式字符串")
    private String channelExt = "";

    @ApiModelProperty(name = "paramExt", value = "参数扩展字段, 回调时会原样返回, json 格式字符串")
    private String paramExt = "";

    @ApiModelProperty(name = "expiredTime", value = "订单失效时间(秒), 默认: 1800 (半小时)")
    private int expiredTime = 1800;

    @ApiModelProperty(name = "notifyUrl", value = "支付结果异步回调URL")
    private String notifyUrl = "";

    @ApiModelProperty(name = "returnUrl", value = "支付结果同步跳转通知URL")
    private String returnUrl = "";


    /**
     * 验签
     */
    @ApiModelProperty(name = "signType", value = "签名类型, 默认MD5")
    private String signType = "MD5";

    @ApiModelProperty(name = "sign", required = true, value = "签名")
    @NotBlank(message = "验签不能为空")
    private String sign;
}
