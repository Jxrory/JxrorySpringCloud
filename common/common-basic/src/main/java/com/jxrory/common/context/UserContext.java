package com.jxrory.common.context;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 在线程中暂存用户相关的信息
 *
 * @author Rory
 * @date 2022/03/14
 */
public class UserContext {

    private static ThreadLocal<Map<String, Object>> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

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
    public static final String CONTEXT_KEY_LOCALE = "locale";


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
    public static void setUserId(String userId) {
        set(CONTEXT_KEY_USER_ID, userId);
    }

    /**
     * 获取用户Id
     *
     * @return 用户Id
     */
    public static String getUserId() {
        Object value = get(CONTEXT_KEY_USER_ID);
        return String.valueOf(value);
    }

    /**
     * 保存用户Token
     */
    public static void setToken(String token) {
        set(CONTEXT_KEY_USER_TOKEN, token);
    }

    public static String getToken() {
        Object value = get(CONTEXT_KEY_USER_TOKEN);
        return String.valueOf(value);
    }

    /**
     * 设置前端用户选择的语言
     */
    public static void setLocale(Locale locale) {
        set(CONTEXT_KEY_LOCALE, locale);
    }

    public static Locale getLocale() {
        Object value = get(CONTEXT_KEY_LOCALE);
        if (value == null) {
            return Locale.US;
        }
        return (Locale) value;
    }
}
