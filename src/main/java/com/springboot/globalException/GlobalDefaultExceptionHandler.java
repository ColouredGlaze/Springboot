package com.springboot.globalException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MingT on 2017/7/11.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public void defaultErrorHandler(HttpServletRequest request,Exception e){
//        System.err.println(e.getMessage());
//        System.err.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
//    }
}
