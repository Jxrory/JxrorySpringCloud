package com.jxrory.common.api;

/**
 * 错误码抽象类
 *
 * @author Rory
 * @date 2022/02/25
 */
public interface IErrorCode {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMsg();
}
