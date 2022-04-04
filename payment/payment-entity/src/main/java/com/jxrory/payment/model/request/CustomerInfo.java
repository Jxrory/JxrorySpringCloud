package com.jxrory.payment.model.request;

import com.jxrory.common.entity.PhoneNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 充值客户的信息, 渠道不同索要的用户信息也会不同的
 *
 * @author Rory
 * @date 2022/04/04
 */
@Data
@ApiModel(description = "充值客户的信息, 渠道不同索要的用户信息也会不同的")
public class CustomerInfo {

    @ApiModelProperty(name = "name", required = true, value = "用户名", example = "Rory")
    private String name;

    @ApiModelProperty(name = "email", value = "用户邮箱", example = "rory@jxrory.com")
    private String email;

    @ApiModelProperty(name = "phone", value = "用户手机号")
    private PhoneNumber phone;

    @ApiModelProperty(name = "clientIp", value = "客户端Ip地址", example = "127.0.0.1")
    private String clientIp = "";
}
