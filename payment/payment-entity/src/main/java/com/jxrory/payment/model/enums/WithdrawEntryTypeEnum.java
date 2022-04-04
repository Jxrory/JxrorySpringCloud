package com.jxrory.payment.model.enums;

import lombok.Getter;

/**
 * 提现入账方式
 *
 * @author Rory
 * @date 2022/03/27
 */
@Getter
public enum WithdrawEntryTypeEnum {
    // 银行卡入账
    BANK_CARD("银行卡"),
    WX("微信"),
    ;

    String detail;

    WithdrawEntryTypeEnum(String detail) {
        this.detail = detail;
    }
}
