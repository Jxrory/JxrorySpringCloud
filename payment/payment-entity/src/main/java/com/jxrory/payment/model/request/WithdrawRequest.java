package com.jxrory.payment.model.request;

import com.jxrory.common.entity.AmountEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 提现请求参数
 * 以什么样的方式提现多少金额到什么地方.
 *
 * @author Rory
 * @date 2022/03/27
 */
@Data
@ApiModel(description = "提现请求参数")
public class WithdrawRequest {

    @ApiModelProperty(name = "countryCode", value = "国家Code", required = true, example = "CN")
    private String countryCode;

    @ApiModelProperty(name = "orderNo", required = true, value = "订单号", example = "Order_000000001")
    @NotBlank(message = "唯一订单号不能为空")
    private String orderNo;


    /**
     * 提现多少钱
     */
    @ApiModelProperty(name = "amount", required = true, value = "提现金额")
    @NotNull
    private AmountEntity amount;


    /**
     * 到什么地方去: 收款人信息
     */
    @ApiModelProperty(name = "recipient", required = true, value = "收款人信息")
    private RecipientInfo recipient;


    /**
     * 其它
     */
    @ApiModelProperty(name = "comment", value = "备注, 默认: Withdraw", example = "Withdraw")
    private String comment = "Withdraw";

    @ApiModelProperty(name = "channelExt", value = "渠道扩展数据, json 格式字符串")
    private String channelExt = "";

    @ApiModelProperty(name = "paramExt", value = "参数扩展字段, 回调时会原样返回, json 格式字符串")
    private String paramExt = "";

    @ApiModelProperty(name = "notifyUrl", value = "支付结果异步回调URL")
    private String notifyUrl = "";


    /**
     * 验签
     */
    @ApiModelProperty(name = "signType", value = "签名类型, 默认MD5")
    private String signType = "MD5";

    @ApiModelProperty(name = "sign", required = true, value = "签名")
    @NotBlank(message = "验签不能为空")
    private String sign;
}
