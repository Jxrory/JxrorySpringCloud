package com.jxrory.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 手机号
 *
 * @author Rory
 * @date 2022/03/03
 */
@Data
@ApiModel(description = "手机号码")
public class PhoneNumber {

    /**
     * 地区码
     */
    @NotEmpty
    @ApiModelProperty(name = "code", value = "手机号国际区号", required = true, example = "\"86\"")
    private String code;

    /**
     * 手机号
     */
    @NotEmpty
    @ApiModelProperty(name = "value", value = "手机号", required = true, example = "\"15732136558\"")
    private String value;

    public String toStr() {
        return code + value;
    }
}
