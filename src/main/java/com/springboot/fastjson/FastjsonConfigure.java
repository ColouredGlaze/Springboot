package com.springboot.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 配置FastJson的第二种方法
 * 1、启动类继承extends WebMvcConfigurerAdapter
 * 2、覆盖方法configureMessageConverters
 * 第一种方法见com.springboot.App
 * Created by MingT on 2017/7/12.
 */
@SpringBootApplication
public class FastjsonConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
    }
    /**
     * 验证FastJson是否配置成功：
     * 在实体类中使用@JSONField(serialize=false)，
     * 如果此字段不返回了，则配置成功
     * 其中JSONField的包路径是：com.alibaba.fastjson.annotation.JSONField。
     */
}
