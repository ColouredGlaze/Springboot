package com.springboot.customSLFH;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义Filter
 * Created by MingT on 2017/7/12.
 */
@WebFilter(filterName = "CustomFilter",urlPatterns = "/")
public class CustomFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println(">>>>>>>>>过滤器初始化！！！ com.springboot.customSLFH.CustomFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println(">>>>>>>>>执行过滤操作！！！ com.springboot.customSLFH.CustomFilter.doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.err.println(">>>>>>>>>过滤器销毁！！！ com.springboot.customSLFH.CustomFilter");
    }
}
