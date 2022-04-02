package com.jxrory.common.components.cors.anantation;

import com.jxrory.common.components.cors.config.CorsConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启跨域
 *
 * @author Rory
 * @date 2022/04/02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CorsConfig.class})
public @interface EnableCors {
}
