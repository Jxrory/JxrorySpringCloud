package com.jxrory.components.web.basic.filter;

import com.jxrory.common.context.TraceIdContext;
import com.jxrory.common.context.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author Rory
 * @since 2022-05-06
 */
@Slf4j
public class WebLoggingFilter extends AbstractRequestLoggingFilter {

    public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        // 设置 language
        setLanguage(request);

        // RequestId 处理
        String requestId = request.getHeader(TraceIdContext.TRACE_ID_KEY);
        if (StringUtils.isBlank(requestId)) {
            requestId = TraceIdContext.newTraceId();
        }
        TraceIdContext.setTraceId(requestId);

        // 打印请求参数
        log.debug("");
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
        // 打印返回参数
        log.debug("");

        // 移除 RequestId
        TraceIdContext.removeTraceId();
    }

    private void setLanguage(HttpServletRequest request) {
        String localStr = request.getHeader(UserContext.CONTEXT_KEY_LOCALE);

        Locale locale = LocaleUtils.toLocale(localStr);

        if (locale == null) {
            locale = request.getLocale();
        }

        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }
        UserContext.setLocale(locale);
    }
}