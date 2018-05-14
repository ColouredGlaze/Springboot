package com.springboot.customSLFH;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 步骤：
 *      1、添加WebServlet注解
 *      2、在SpringBoot的启动类App中添加@Bean getCustomServlet()
 * Created by MingT on 2017/7/12.
 */
@WebServlet(urlPatterns = "/CustomServlet2/*",description = "自定义Servlet方法二")
public class CustomServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>com.springboot.customSLFH.CustomServlet2 doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>com.springboot.customSLFH.CustomServlet2 doPost()<<<<<<<<<<<");
        resp.setContentType("text/fetch");
        PrintWriter out = resp.getWriter();
        out.println("<fetch>");
        out.println("<head>");
        out.println("<title>CustomServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>This is com.springboot.customSLFH.CustomServlet2</h1>");
        out.println("</body>");
        out.println("</fetch>");
    }
}
