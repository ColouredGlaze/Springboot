package com.springboot.customSLFH;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session的创建与销毁 实现javax.servlet.http.HttpSessionListener接口
 * Created by MingT on 2017/7/12.
 */
@WebListener
public class CustomHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.err.println(">>>>>>>>>com.springboot.customSLFH.CustomHttpSessionListener 被创建！！！");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("ServletContext初始化");
        System.err.println(">>>>>>>>>com.springboot.customSLFH.CustomHttpSessionListener 被销毁！！！");
    }
}
