package com.jxrory.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 在线程中暂存用户相关的信息
 *
 * @author Rory
 * @date 2022/03/14
 */
public class UserContext {

    private static ThreadLocal<Map<String, Object>> threadLocal;

    /**
     * tokenKey
     */
    public static final String CONTEXT_KEY_USER_TOKEN = "token";

    /**
     * 用户idKey
     */
    public static final String CONTEXT_KEY_USER_ID = "userId";

    /**
     * 语言 code
     */
    public static final String CONTEXT_KEY_LANGUAGE_CODE = "language";

    /**
     * 用户信息
     */
    public static final String CONTEXT_KEY_USER_INFO = "userInfo";

    static {
        threadLocal = new ThreadLocal<>();
    }

    /**
     * 设置数据
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>(6);
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    /**
     * 获取数据
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>(6);
            threadLocal.set(map);
        }
        return map.get(key);
    }

    /**
     * 清除数据
     * NOTICE: 请求完成后必须清除数据, 防止 OOM
     */
    public static void remove() {
        threadLocal.remove();
    }

    /**
     * 设置用户Id
     *
     * @param userId 用户Id
     */
    public static void setUserId(Long userId) {
        set(CONTEXT_KEY_USER_ID, userId);
    }

    /**
     * 获取用户Id
     *
     * @return 用户Id
     */
    public static Long getUserId() {
        Object value = get(CONTEXT_KEY_USER_ID);
        return Long.valueOf(String.valueOf(value));
    }

    /**
     * 设置前端使用的语言Code
     *
     * @param languageCode 语言Code, 参考 ISO 标准
     */
    public static void setLanguageCode(String languageCode) {
        set(CONTEXT_KEY_LANGUAGE_CODE, languageCode);
    }

    /**
     * 获取语言Code
     *
     * @return 语言Code
     */
    public static String getLanguageCode() {
        Object value = get(CONTEXT_KEY_LANGUAGE_CODE);
        return String.valueOf(value);
    }

    /**
     * 保存用户 token
     *
     * @param token token
     */
    public static void setToken(String token) {
        set(CONTEXT_KEY_USER_TOKEN, token);
    }

    /**
     * 获取用户 token
     *
     * @return 用户token
     */
    public static String getToken() {
        Object value = get(CONTEXT_KEY_USER_TOKEN);
        return String.valueOf(value);
    }
}
