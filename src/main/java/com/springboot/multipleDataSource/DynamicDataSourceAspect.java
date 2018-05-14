package com.springboot.multipleDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MingTie
 * CreateDate：2017/9/3
 * Description：
 */
@Aspect
@Order(-9)
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
        // 获取当前指定的数据源；
        String dsId = targetDataSource.value();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)){
            System.err.println("数据源[{}]不存在，使用默认数据源 > {}"+targetDataSource.value()+joinPoint.getSignature());
        } else {
            System.out.println("Use DataSource : {} > {}"+targetDataSource.value()+joinPoint.getSignature());
            //找到的话，那么设置到动态数据源上下文中。
            DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint joinPoint, TargetDataSource targetDataSource){
        System.out.println("Revert DataSource : {} > {}"+targetDataSource.value()+joinPoint.getSignature());
        // 方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
