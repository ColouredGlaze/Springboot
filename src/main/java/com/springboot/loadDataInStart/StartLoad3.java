package com.springboot.loadDataInStart;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MingTie
 * CreateDate：2017/8/14
 * Description：
 */
@Component
@Order(value = 3)
public class StartLoad3 implements ApplicationRunner{
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据 Order(value = 3) implements ApplicationRunner<<<<<<<<<<<<<");
    }
}
