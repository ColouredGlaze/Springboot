package com.springboot.loadDataInStart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MingTie
 * CreateDate：2017/8/14
 * Description：
 */
@Component
@Order(value = 2)
public class StartLoad2 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据 Order(value = 2) implements CommandLineRunner<<<<<<<<<<<<<");
    }
}
