package com.springboot.customSLFH;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义Servlet
 * 方法一：
 *      1、定义一个类继承javax.servlet.http.HttpServlet
 *      2、在SpringBoot启动类App中使用@Bean进行注册
 * 方法二：
 *      1、使用注解的方式：com.springboot.customSLFH.CustomServlet2
 * Created by MingT on 2017/7/12.
 */
public class CustomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>com.springboot.customSLFH.CustomServlet doGet()<<<<<<<<<<<");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>com.springboot.customSLFH.CustomServlet doPost()<<<<<<<<<<<");
        response.setContentType("text/fetch");
        PrintWriter out = response.getWriter();
        out.println("<fetch>");
        out.println("<head>");
        out.println("<title>CustomServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>This is com.springboot.customSLFH.CustomServlet!!!</h1>");
        out.println("</body>");
        out.println("</fetch>");
    }
}
