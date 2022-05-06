package com.jxrory.components.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rory
 * @date 2022/04/02
 */
@Slf4j
@Configuration
@EnableAutoConfiguration
@ConditionalOnProperty(name = "swagger.enable")
public class SwaggerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        log.debug("swaggerProperties init...");
        return new SwaggerProperties();
    }

    @Bean
    public Docket api(SwaggerProperties swaggerProperties) {
        log.debug("SwaggerAutoConfiguration.api init.....");

        /*添加接口请求头参数配置 没有的话 可以忽略*/
        List<Parameter> pars = new ArrayList<>();

        log.debug("SwaggerAutoConfiguration.api headers={}", swaggerProperties.getHeaders());

        ParameterBuilder tokenPar = new ParameterBuilder();
        for (SwaggerProperties.HeaderInfo item : swaggerProperties.getHeaders()) {
            tokenPar.name(item.getKey())
                    .description(item.getDescription())
                    .defaultValue(item.getValue())
                    .modelRef(new ModelRef("string"))
                    .parameterType("header")
                    .required(item.getRequest()).build();
            pars.add(tokenPar.build());
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerProperties.getGroup())
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo(swaggerProperties))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                // 创建
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                // swagger标题
                .title(swaggerProperties.getTitle())
                // api详细描述
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                // 条款地址
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(
                        swaggerProperties.getContact().getName(),
                        swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()
                ))
                .version(swaggerProperties.getVersion())
                .build();
    }
}
