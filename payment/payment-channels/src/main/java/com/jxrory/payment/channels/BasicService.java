package com.jxrory.payment.channels;


import com.jxrory.common.entity.AmountEntity;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 基础服务
 *
 * @author Rory
 * @date 2022/04/04
 */
public interface BasicService {

    /**
     * 获取账户余额
     *
     * @return 余额
     */
    Map<String, AmountEntity> getBalance();

    /**
     * 获取账户余额
     *
     * @param currency 币种
     * @return 余额
     */
    default AmountEntity getBalance(String currency) {
        Map<String, AmountEntity> balance = getBalance();
        return balance.getOrDefault(currency, new AmountEntity(currency, new BigDecimal(0)));
    }
}
