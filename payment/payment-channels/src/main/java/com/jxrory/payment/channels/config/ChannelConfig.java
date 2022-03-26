package com.jxrory.payment.channels.config;

import lombok.Data;

/**
 * 渠道配置
 *
 * @author Rory
 * @date 2022/03/26
 */
@Data
public class ChannelConfig {

    /**
     * 基础 URL
     */
    private String basicUrl;

    /**
     * 秘钥
     */
    private String secretKey;

    /**
     * 回调 URL
     */
    private String callbackUrl;
}
