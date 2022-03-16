package com.jxrory.common.validation;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.jxrory.common.entity.PhoneNumber;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号校验
 *
 * @author Rory
 * @date 2022/03/03
 */
@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<Phone, PhoneNumber> {

    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();

    @Override
    public boolean isValid(PhoneNumber phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.getCode() == null || phoneNumber.getValue() == null) {
            log.error("phone number is error phoneNumber={}", phoneNumber);
            return false;
        }

        Phonenumber.PhoneNumber pn = new Phonenumber.PhoneNumber();
        try {
            pn.setCountryCode(Integer.parseInt(phoneNumber.getCode()));
            pn.setNationalNumber(Long.parseLong(phoneNumber.getValue()));
        } catch (Exception e) {
            log.error("phone number parse error phoneNumber={}", phoneNumber);
            return false;
        }

        return PHONE_NUMBER_UTIL.isValidNumber(pn);
    }
}