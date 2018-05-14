package com.springboot.registerBeanByJavaCode;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @author MingTie
 * CreateDate：2017/8/22
 * Description：将Bean注册给Spring管理
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{


    /**
     * Bean的名称生成器
     */
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();


    /**
     * 先执行：postProcessBeanDefinitionRegistry()方法
     * 方法postProcessBeanDefinitionRegistry()是用来注册bean的
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println(">>>>>>>>>com.springboot.registerBeanByJavaCode." +
                "MyBeanDefinitionRegistryPostProcessor." +
                "postProcessBeanDefinitionRegistry()<<<<<<<<<");
        /**
         * 在这里可以注入Bean
         */
        this.registerBean(beanDefinitionRegistry, "RegisterBeanImplA", RegisterBeanImplA.class);
        this.registerBean(beanDefinitionRegistry, "RegisterBeanImplB", RegisterBeanImplB.class);
        this.registerBean(beanDefinitionRegistry, "RegisterBeanC", RegisterBeanC.class);
    }

    /**
     * 再执行：postProcessBeanFactory()方法
     * postProcessBeanFactory()是bean配置的工厂方法，在这个方法中可以获取到我们所有在
     * postProcessBeanDefinitionRegistry方法中注册的所有bean，在这里我们可以进行属性的设置等操作。
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(">>>>>>>>>com.springboot.registerBeanByJavaCode." +
                "MyBeanDefinitionRegistryPostProcessor." +
                "postProcessBeanFactory()<<<<<<<<<");
        /**
         * 在这里可以设置注册的Bean的属性
         */
        BeanDefinition beanDefinition = configurableListableBeanFactory
                .getBeanDefinition("RegisterBeanC");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("beanName","RegisterBeanC");
    }

    /**
     * 公共的注册方法
     * @param registry
     * @param name
     * @param beanClass
     */
    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass){
        AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);

        /**
         * 自动生成name
         */
        String beanName = (
                name != null ? name :
                        this.beanNameGenerator.generateBeanName(annotatedBeanDefinition,registry));

        /**
         * Bean注册的Holder类
         */
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);

        /**
         * 使用Bean注册工具类进行注册
         */
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
    }
}
