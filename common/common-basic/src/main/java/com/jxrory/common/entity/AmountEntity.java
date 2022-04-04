package com.jxrory.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Rory
 * @date 2022/04/04
 */
@Data
@ApiModel(description = "金额")
public class AmountEntity {

    /**
     * 最后会转换为 {@link java.util.Currency}
     */
    @ApiModelProperty(name = "currency", value = "币种", required = true, example = "CNY")
    private String currency;

    @ApiModelProperty(name = "value", value = "金额", required = true, example = "100.00")
    private BigDecimal value;

    public AmountEntity() {
    }

    public AmountEntity(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }
}
