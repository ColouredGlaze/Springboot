package com.springboot.registerBeanByJavaCode;

/**
 * @author MingTie
 * CreateDate：2017/8/22
 * Description：
 */
public class RegisterBeanImplA implements RegisterBean{

    @Override
    public void selfIntroduction() {
        System.out.println(">>>>>>>>>com.springboot.registerBeanByJavaCode." +
                "RegisterBeanImplA.selfIntroduction()<<<<<<<<<");
    }
}
