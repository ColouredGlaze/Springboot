package com.springboot.registerBeanByJavaCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/22
 * Description：
 */
@RestController
public class RegisterBeanByJavaCodeController {

    @Resource(name ="RegisterBeanImplA")
    private RegisterBean registerBeanA;

    @Autowired
    @Qualifier("RegisterBeanImplB")
    private RegisterBean registerBeanB;

    @Autowired
    @Qualifier("RegisterBeanC")
    private RegisterBeanC registerBeanC;

    @RequestMapping("RegisterBeanByJavaCode")
    public String RegisterBeanByJavaCode(){
        registerBeanA.selfIntroduction();
        registerBeanB.selfIntroduction();
        return registerBeanC.getBeanName();
    }
}
