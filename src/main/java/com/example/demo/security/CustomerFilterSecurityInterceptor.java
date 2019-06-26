package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class CustomerFilterSecurityInterceptor implements Filter {
    Logger logger = LoggerFactory.getLogger(CustomerFilterSecurityInterceptor.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("filter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.debug("filter destroy");
    }
}
