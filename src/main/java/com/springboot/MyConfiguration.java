package com.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author MingTie
 * CreateDate：2017/8/14
 * Description：添加允许跨域访问的链接
 */
@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer addCrossDomainConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**");
                super.addCorsMappings(registry);
            }
        };
    }
}
