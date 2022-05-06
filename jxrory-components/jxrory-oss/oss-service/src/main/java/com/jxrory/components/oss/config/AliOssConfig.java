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
@ConfigurationProperties(prefix = "oss.ali")
@ConditionalOnProperty(prefix = "oss.ali", name = "enable", havingValue = "true")
public class AliOssConfig {

    /**
     * 默认不开启
     */
    private Boolean enable = false;
    private String ossUrl;
    private String accessId;
    private String accessKey;
    

    private String bucketName;
    private String path;
    private String httpUrl;
}
