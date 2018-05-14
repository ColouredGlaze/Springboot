package com.springboot.loadDataInStart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MingTie
 * CreateDate：2017/8/14
 * Description：
 */
@Component
@Order(value = 1)
public class StartLoad1 implements CommandLineRunner{
    @Override
    public void run(String... strings) {
        // strings 即启动类的main函数的参数 args[]
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据 Order(value = 1) implements CommandLineRunner<<<<<<<<<<<<<");
    }
}
