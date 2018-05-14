package com.springboot.junit;

import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：
 */
public class JunitServiceTest2 extends BaseTestService{
    @Resource
    private JunitService junitService;

    @Test
    public void testGetHello(){
        System.out.println(junitService.getHello());
        Assert.assertEquals("不一样！", "Hello Springboot Junit Test!",junitService.getHello());
    }
}
