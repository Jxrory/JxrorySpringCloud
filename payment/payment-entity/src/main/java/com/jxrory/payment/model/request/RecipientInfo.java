package com.jxrory.payment.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 收款人信息, 根据渠道的不同, 要求的信息也是不同的
 *
 * @author Rory
 * @date 2022/04/04
 */
@Data
@ApiModel(description = "收款人信息, 根据渠道的不同, 要求填写的信息也是不同的")
public class RecipientInfo {

    @ApiModelProperty(name = "accountNo", required = true, value = "银行卡号, wxpay-openID, alipay-登录账号", example = "\"1234567890\"")
    @NotBlank
    private String accountNo;

    @ApiModelProperty(name = "bankCode", value = "银行 code", example = "JH")
    private String bankCode;

    @ApiModelProperty(name = "accountName", value = "收款人姓名", example = "Rory")
    private String name;

    @ApiModelProperty(name = "clientIp", value = "客户端Ip地址", example = "127.0.0.1")
    private String clientIp = "";
}
