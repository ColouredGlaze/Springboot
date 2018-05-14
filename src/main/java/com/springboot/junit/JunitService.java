package com.springboot.junit;

import org.springframework.stereotype.Service;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：使用springboot中的Junit的辅助测试类
 */
@Service
public class JunitService {

    public String getHello(){
        return "Hello Springboot Junit Test!";
    }
}
