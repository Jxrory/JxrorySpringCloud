package com.jxrory.components.web.basic.handler;

import com.jxrory.common.context.TraceIdContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rory
 * @since 2022-05-07
 */
public class RequestIdHandler {

    public static void set(HttpServletRequest servletRequest) {
        // RequestId 处理
        String requestId = servletRequest.getHeader(TraceIdContext.TRACE_ID_KEY);
        if (StringUtils.isBlank(requestId)) {
            requestId = TraceIdContext.newTraceId();
        }
        TraceIdContext.setTraceId(requestId);
    }

    public static void clear() {
        TraceIdContext.clearTraceId();
    }
}
