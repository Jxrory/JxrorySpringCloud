package com.jxrory.components.oss.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Data
@ConfigurationProperties(prefix = "oss")
public class OssProperties {

    /**
     * 是否开启默认 controller
     */
    private OssControllerConfig controller = new OssControllerConfig();

    @Data
    @NoArgsConstructor
    public class OssControllerConfig {
        private Boolean enable;
    }

}
