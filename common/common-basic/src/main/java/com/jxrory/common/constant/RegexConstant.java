package com.jxrory.common.constant;

/**
 * 常用正则常量
 *
 * @author Rory
 * @date 2022/04/02
 */
public interface RegexConstant {

    /**
     * 密码正则:
     * 1.密码必须由大小写字母、数字组成, 不包含特殊符号
     * 2.密码长度为6-18位
     * <p>
     * <p>
     * 尾部数字含义:
     * [1111]: 大写字母, 小写字母, 数字, 特殊字符
     */
    String PASSWORD_1110 = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]{6,18}$";
    String PASSWORD_1111 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[^.]{6,18}$";

    /**
     * 6位数的验证码正则
     */
    String VERIFY_CODE_6 = "^\\d{6}$";
}
