package com.springboot.customSLFH;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author MingTie
 * CreateDate：2017/8/14
 * Description：添加拦截器
 * 只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，
 * 比如我们自定义的Servlet地址http://localhost:8080/myServlet1 是不会被拦截器拦截的。
 * 并且不管是属于哪个Servlet 只要复合过滤器的过滤规则，过滤器都会拦截。
 *
 * 没有起作用
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor1()).addPathPatterns("/**").excludePathPatterns("/CustomInterceptor1/**");
        registry.addInterceptor(new CustomInterceptor2()).addPathPatterns("/CustomInterceptor2/*");
        super.addInterceptors(registry);
    }
}
