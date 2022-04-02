package com.jxrory.payment.model.vo;

import com.jxrory.payment.model.enums.RechargeOrderStatusEnum;
import com.jxrory.payment.model.enums.RechargePayDataTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Rory
 * @date 2022/03/27
 */
@Data
@ApiModel(description = "充值返回", value = "充值返回")
public class RechargeVO {

    @ApiModelProperty(name = "orderNo", value = "订单号", example = "Order_000000001")
    private String orderNo;

    @ApiModelProperty(name = "status", value = "订单状态", example = "CREATED")
    private RechargeOrderStatusEnum status;

    @ApiModelProperty(name = "payDataType", value = "data的类型")
    private RechargePayDataTypeEnum payDataType;

    @ApiModelProperty(name = "payData", value = "支付数据", example = "http://www.jxrory.com/pay.html")
    private String payData;
}
