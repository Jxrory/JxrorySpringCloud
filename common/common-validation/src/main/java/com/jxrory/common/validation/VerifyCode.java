package com.jxrory.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 验证码校验注解
 *
 * @author Rory
 * @date 2022/03/03
 */
@Documented
@Constraint(validatedBy = VerifyCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyCode {

    String locale() default "";

    String message() default "Invalid verify code format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}