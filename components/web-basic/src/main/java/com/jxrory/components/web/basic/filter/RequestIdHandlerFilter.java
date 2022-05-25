package com.jxrory.components.web.basic.filter;

import com.jxrory.components.web.basic.handler.RequestIdHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Rory
 * @since 2022-05-07
 */
@Component
@Order(2147483647 / 2)
@WebFilter(filterName = "requestIdHandlerFilter", urlPatterns = "/*")
@ConditionalOnProperty(prefix = "web.filter.requestId", name = "enable", havingValue = "true", matchIfMissing = true)
public class RequestIdHandlerFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(RequestIdHandlerFilter.class);

    /**
     * filter对象只会创建一次，init方法也只会执行一次
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.debug("RequestIdHandlerFilter begin...");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        // 处理 request Id
        RequestIdHandler.set(httpServletRequest);

        filterChain.doFilter(servletRequest, servletResponse);

        RequestIdHandler.clear();

        log.debug("RequestIdHandlerFilter end...");
    }

    /**
     * 在销毁Filter时自动调用（程序关闭或者主动销毁Filter）
     */
    @Override
    public void destroy() {
    }
}
