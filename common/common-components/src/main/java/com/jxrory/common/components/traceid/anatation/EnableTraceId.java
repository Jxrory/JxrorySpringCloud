package com.jxrory.common.components.traceid.anatation;

import com.jxrory.common.components.traceid.config.TranceIdConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启收集 RequestId 功能
 *
 * @author Rory
 * @date 2022/04/02
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({TranceIdConfig.class})
public @interface EnableTraceId {
}
