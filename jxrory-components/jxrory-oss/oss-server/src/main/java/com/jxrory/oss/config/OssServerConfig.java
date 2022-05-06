package com.jxrory.oss.config;


import com.jxrory.common.components.cors.anantation.EnableCors;
import com.jxrory.common.components.swagger.anantation.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rory
 * @date 2022-04-13
 */
@Configuration
@EnableSwagger2
@EnableCors
public class OssServerConfig {
}
