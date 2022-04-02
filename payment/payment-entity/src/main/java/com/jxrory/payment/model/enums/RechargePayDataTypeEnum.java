package com.jxrory.payment.model.enums;

import lombok.Getter;

/**
 * 充值返回值的类型
 *
 * @author Rory
 * @date 2022/03/27
 */
@Getter
public enum RechargePayDataTypeEnum {
    // URL 的形式
    URL("URL形式"),
    FORM("表单形式"),
    ;

    /**
     * 描述
     */
    private String detail;

    RechargePayDataTypeEnum(String detail) {
        this.detail = detail;
    }
}
