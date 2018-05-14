package com.springboot.multipleDataSource;

import java.lang.annotation.*;

/**
 * @author MingTie
 * CreateDate：2017/9/3
 * Description：
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
