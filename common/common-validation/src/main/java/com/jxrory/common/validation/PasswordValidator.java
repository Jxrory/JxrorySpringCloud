package com.jxrory.common.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 密码校验
 *
 * @author Rory
 * @date 2022/03/03
 */
@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, String> {

    /**
     * 密码规则:
     * 1.密码必须由字母、数字组成，区分大小写
     * 2.密码长度为6-18位
     */
    private static final String PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]{6,18}$";


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }

        return value.matches(PASSWORD_REGEX);
    }
}