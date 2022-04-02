package com.jxrory.common.validation;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rory
 * @date 2022/04/01
 */
@Data
public class PatternValidator implements ConstraintValidator<Pattern, String> {

    private String regexp = "";

    @Override
    public void initialize(Pattern constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // value 为 blank 时直接忽略
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.matches(regexp);
    }
}
