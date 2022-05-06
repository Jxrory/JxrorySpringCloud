package com.jxrory.components.oss.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({OssProperties.class})
public class OssAutoConfiguration {

    @PostConstruct
    void init() {
        log.debug("OssAutoConfiguration.init...");
    }
}
