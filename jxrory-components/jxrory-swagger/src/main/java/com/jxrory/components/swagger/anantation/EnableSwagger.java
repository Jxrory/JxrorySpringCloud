package com.jxrory.components.swagger.anantation;

import com.jxrory.components.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.lang.annotation.*;

/**
 * @author Rory
 * @date 2022/04/02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableSwagger2WebMvc
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSwagger {
}
