package com.jxrory.components.web.basic.filter;

import com.jxrory.components.web.basic.handler.RequestIdHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Rory
 * @since 2022-05-07
 */
@Slf4j
//@Component
@Order(2147483647 / 2 + 100)
@WebFilter(filterName = "paramsLogFilter", urlPatterns = "/*")
//@ConditionalOnProperty(prefix = "web.filter.paramsLog", havingValue = "enable", matchIfMissing = true)
public class ParamsLogFilter implements Filter {

    /**
     * filter对象只会创建一次，init方法也只会执行一次
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

//        ResponseWrapper responseWrapper = new ResponseWrapper(Thread.currentThread().getId(), (HttpServletResponse) servletResponse);
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        RequestWrapper requestWrapper = new RequestWrapper(Thread.currentThread().getId(), httpServletRequest);

        filterChain.doFilter(servletRequest, servletResponse);

        RequestIdHandler.clear();

        log.debug("RequestIdHandlerFilter end...");
    }

    /**
     * 在销毁Filter时自动调用（程序关闭或者主动销毁Filter）
     */
    @Override
    public void destroy() {
        log.debug("RequestIdHandlerFilter destroy...");
    }
}
