package com.springboot.customSLFH;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HandlerInterceptor 的功能跟过滤器类似，但是提供更精细的的控制能力：
 * 在request被响应之前、request被响应之后、视图渲染之前以及request全部结束之后。
 * 我们不能通过拦截器修改request内容，但是可以通过抛出异常（或者返回false）来暂停request的执行。
 *
 * 实现 UserRoleAuthorizationInterceptor 的拦截器有：
 * ConversionServiceExposingInterceptor
 * CorsInterceptor
 * LocaleChangeInterceptor
 * PathExposingHandlerInterceptor
 * ResourceUrlProviderExposingInterceptor
 * ThemeChangeInterceptor
 * UriTemplateVariablesHandlerInterceptor
 * UserRoleAuthorizationInterceptor
 * 其中 LocaleChangeInterceptor 和 ThemeChangeInterceptor 比较常用。
 * Created by MingT on 2017/7/12.
 */

/*    配置拦截器也很简单，Spring 为什么提供了基础类WebMvcConfigurerAdapter ，我们只需要重写 addInterceptors 方法添加注册拦截器。
实现自定义拦截器只需要3步：
       1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。
       2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。
       3、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。
*/
// 自定义拦截器方法一：
public class CustomInterceptor1 implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.err.println(httpServletRequest.getRequestURL());
        System.out.println(">>>com.springboot.customSLFH.CustomInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(">>>com.springboot.customSLFH.CustomInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(">>>com.springboot.customSLFH.CustomInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
