package com.jxrory.payment.model.request;

import com.jxrory.payment.model.enums.WithdrawEntryTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 提现请求参数
 * 以什么样的方式提现多少金额到什么地方.
 *
 * @author Rory
 * @date 2022/03/27
 */
@Data
@ApiModel(description = "提现请求参数", value = "提现请求参数")
public class WithdrawRequest {

    @ApiModelProperty(name = "countryCode", value = "国家Code", required = true, example = "CN")
    private String countryCode;

    @ApiModelProperty(name = "orderNo", required = true, value = "订单号", example = "Order_000000001")
    @NotBlank(message = "唯一订单号不能为空")
    private String orderNo;


    /**
     * 提现方式
     */
    @ApiModelProperty(name = "entryType", required = true, value = "入账方式", example = "BANK_CARD")
    private WithdrawEntryTypeEnum entryType;


    /**
     * 提现多少钱
     */
    @ApiModelProperty(name = "currency", required = true, value = "币种: ISO-4217", example = "CNY")
    @NotBlank(message = "币种不能为空")
    private String currency;

    @ApiModelProperty(name = "amount", required = true, value = "金额, 使用基础单位: 元", example = "100.00")
    private BigDecimal amount;


    /**
     * 到什么地方去
     */
    @ApiModelProperty(name = "accountNo", required = true, value = "银行卡号, wxpay-openID, alipay-登录账号", example = "\"1234567890\"")
    private String accountNo;

    @ApiModelProperty(name = "bankCode", value = "银行 code", example = "JH")
    private String bankCode;

    @ApiModelProperty(name = "accountName", value = "收款人姓名", example = "Rory")
    private String accountName;


    /**
     * 其它
     */
    @ApiModelProperty(name = "clientIp", value = "客户端Ip地址", example = "127.0.0.1")
    private String clientIp = "";

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
