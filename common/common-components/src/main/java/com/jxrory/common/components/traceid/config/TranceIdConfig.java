package com.jxrory.common.components.traceid.config;

import com.jxrory.common.context.TraceIdContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rory
 * @date 2022/04/02
 */
@Slf4j
public class TranceIdConfig {

    @Bean
    public TraceIdRequestLoggingFilter traceIdRequestLoggingFilter() {
        log.debug("TranceIdConfig.traceIdRequestLoggingFilter init.....");
        return new TraceIdRequestLoggingFilter();
    }

    static class TraceIdRequestLoggingFilter extends AbstractRequestLoggingFilter {

        @Override
        protected void beforeRequest(HttpServletRequest request, String message) {
            String requestId = request.getHeader(TraceIdContext.TRACE_ID_KEY);
            if (StringUtils.isBlank(requestId)) {
                requestId = TraceIdContext.newTraceId();
            }
            TraceIdContext.setTraceId(requestId);
        }

        @Override
        protected void afterRequest(HttpServletRequest httpServletRequest, String s) {
            TraceIdContext.removeTraceId();
        }
    }
}

