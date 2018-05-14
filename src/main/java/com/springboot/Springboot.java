package com.springboot;

import com.springboot.customSLFH.CustomServlet;
import com.springboot.useCustomProperties.QuiteSetting;
import com.springboot.useCustomProperties.SilenceSetting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Start this spring boot demo Object
 * Created by MingT on 2017/7/11.
 */

/*
 * 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于
 * 以默认属性使用@Configuration、@EnableAutoConfiguration和@Component
 */
@SpringBootApplication
/* 使用@ServletComponentScan注解后，自定义的Servlet、Filter、Listener 可以直接通过
@WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码 */
@ServletComponentScan
// 加载
@EnableConfigurationProperties({QuiteSetting.class, SilenceSetting.class})
// 指定springboot扫描哪些包
@ComponentScan(basePackages = {"org.springboot","com"})
public class Springboot {

   /*
    * 配置FastJson方法一：
    * 方法二见com.springboot.fastjson.FastjsonConfigure
    */
   /* @Bean
      public HttpMessageConverters fastJsonHttpMessageConverters(){
          FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
          FastJsonConfig fastJsonConfig = new FastJsonConfig();
          fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
          fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
          HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
          return new HttpMessageConverters(converter);
      }
    */

    public static void main(String[] args){
        SpringApplication.run(Springboot.class,args);
    }

    // 使用代码的方式注册Filter和Listener与此方法相似，
    // 不同的是需要使用 FilterRegistrationBean 和 ServletListenerRegistrationBean 这两个类。

    // 自定义Servlet：com.springboot.customSLFH.CustomServlet
    @Bean
    public ServletRegistrationBean getCustomServlet(){
//        new FilterRegistrationBean();
//        new ServletListenerRegistrationBean<>();
        return new ServletRegistrationBean(new CustomServlet(),"/CustomServlet/*");
    }
}
