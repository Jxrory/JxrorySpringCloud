package com.jxrory.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * 日志打印 RequestId (TraceId)
 *
 * @author Rory
 * @date 2022/03/16
 */
public class TraceIdContext {

    public static final String TRACE_ID_KEY = "RequestId";

    /**
     * 设置 TraceId
     *
     * @param traceId TraceId
     */
    public static void setTraceId(String traceId) {
        if (StringUtils.isNotEmpty(traceId)) {
            MDC.put(TRACE_ID_KEY, traceId);
        }
    }

    /**
     * 获取 TraceId
     *
     * @return TraceId
     */
    public static String getTraceId() {
        String traceId = MDC.get(TRACE_ID_KEY);
        return traceId == null ? "" : traceId;
    }

    /**
     * 移除 TraceId
     * NOTICE: 请求完成后需要清除 traceId, 防止 OOM
     */
    public static void removeTraceId() {
        MDC.remove(TRACE_ID_KEY);
    }

    /**
     * 清空 MDC
     */
    public static void clearTraceId() {
        MDC.clear();
    }
}
