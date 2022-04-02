package com.jxrory.payment.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 充值请求参数
 *
 * @author Rory
 * @date 2022/03/27
 */
@Data
@ApiModel(description = "充值请求参数", value = "充值请求参数")
public class RechargeRequest {

    @ApiModelProperty(name = "orderNo", required = true, value = "订单号", example = "Order_000000001")
    @NotBlank(message = "唯一订单号不能为空")
    private String orderNo;

    @ApiModelProperty(name = "wayCode", required = true, value = "支付方式", example = "WX-H5")
    private String wayCode;

    @ApiModelProperty(name = "countryCode", value = "国家Code", required = true, example = "CN")
    private String countryCode;

    @ApiModelProperty(name = "currency", required = true, value = "币种: ISO-4217", example = "CNY")
    @NotBlank(message = "币种不能为空")
    private String currency;

    @ApiModelProperty(name = "amount", required = true, value = "金额, 使用基础单位: 元", example = "100.00")
    private BigDecimal amount;

    @ApiModelProperty(name = "clientIp", value = "客户端Ip地址", example = "127.0.0.1")
    private String clientIp = "";

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

    @ApiModelProperty(name = "signType", value = "签名类型, 默认MD5")
    private String signType = "MD5";

    @ApiModelProperty(name = "sign", required = true, value = "签名")
    @NotBlank(message = "验签不能为空")
    private String sign;
}
