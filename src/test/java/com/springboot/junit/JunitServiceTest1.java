package com.springboot.junit;

import com.springboot.Springboot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：使用springboot的Junit测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Springboot.class})
public class JunitServiceTest1 {

    @Resource
    private JunitService junitService;

    @Test
    public void testGetHello(){
        System.out.println(junitService.getHello());
        Assert.assertEquals("不一样！", "Hello Springboot Junit Test!",junitService.getHello());
    }
}
