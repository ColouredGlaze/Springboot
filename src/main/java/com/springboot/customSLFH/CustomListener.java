package com.springboot.customSLFH;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义Listener   使用@WebListener注解，实现javax.servlet.ServletContextListener接口
 * Created by MingT on 2017/7/12.
 */
@WebListener
public class CustomListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.err.println(">>>>>>>>>com.springboot.customSLFH.CustomListener 初始化！！！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.err.println(">>>>>>>>>com.springboot.customSLFH.CustomListener 销毁！！！");
    }
}
