package com.jxrory.common.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证码校验类
 *
 * @author Rory
 * @date 2022/03/03
 */
@Slf4j
public class VerifyCodeValidator implements ConstraintValidator<VerifyCode, String> {

    /**
     * 验证码校验规则:
     * 1. 验证码 6 位数字
     */
    private static final String VERIFY_CODE_REGEX = "^\\d{6}$";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }

        return value.matches(VERIFY_CODE_REGEX);
    }
}