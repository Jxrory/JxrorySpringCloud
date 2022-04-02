package com.jxrory.common.validation;

import com.jxrory.common.api.IErrorCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Rory
 * @date 2022/04/01
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PatternValidator.class)
public @interface Pattern {

    /**
     * @return the regular expression to match
     */
    String regexp();

    /**
     * @return the error code
     */
    Class<? extends IErrorCode>[] errCode() default {};

    /**
     * @return the error message template
     */
    String message() default "{com.jxrory.common.validation.Pattern.message}";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};
}
