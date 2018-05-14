package com.springboot.getEnvironmentAware;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author MingTie
 * CreateDate：2017/8/15
 * Description：在系统启动时，获取环境变量和application配置文件中的变量
 */

// 方法一：
@Configuration
public class MyEnvironmentAware implements EnvironmentAware{

    // 注入application.properties的属性到指定的变量中
    @Value("${spring.datasource.url}")
    private String datasourceURL;

    /**
    * 重写的setEnvironment方法将在系统启动的时候执行
    * */
    @Override
    public void setEnvironment(Environment environment) {
        // 输出注入的属性值
        System.out.println("com.springboot.getEnvironmentAware.MyEnvironmentAware: " + datasourceURL);

        // 通过environment获取系统属性
        System.out.println("JAVA_HOME : "+environment.getProperty("JAVA_HOME"));

        // 通过environment获取application.properties配置的属性
        System.out.println("spring.datasource.driverClassName : " + environment.getProperty("spring.datasource.driverClassName"));

        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println("spring.datasource.username : " + relaxedPropertyResolver.getProperty("username"));
        System.out.println("spring.datasource.password : " + relaxedPropertyResolver.getProperty("password"));
    }
}
