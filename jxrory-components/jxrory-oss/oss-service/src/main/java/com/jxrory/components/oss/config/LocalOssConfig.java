package com.jxrory.components.oss.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "oss.local")
@ConditionalOnProperty(prefix = "oss.local", name = "enable", havingValue = "true")
public class LocalOssConfig {

    /**
     * 默认不开启
     */
    private String path = "data";

    private String httpUrl = "";
}
