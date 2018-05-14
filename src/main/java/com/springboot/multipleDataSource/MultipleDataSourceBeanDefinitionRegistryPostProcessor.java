package com.springboot.multipleDataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author MingTie
 * CreateDate：2017/9/1
 * Description：动态创建多数据源到Spring中
 * BeanDefinitionRegistryPostProcessor：作用：注入Bean
 * EnvironmentAware：重写方法 setEnvironment，在工程启动时，获取到系统环境变量和application配置文件中的变量。
 *  方法的执行顺序是：
 *  setEnvironment()-->postProcessBeanDefinitionRegistry() --> postProcessBeanFactory()
 */
@Configuration
public class MultipleDataSourceBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,EnvironmentAware{

    // 作用域对象
    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

    // bean名称生成器
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    // 如配置文件中未指定数据源类型，使用该默认值
    private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";

    // 存放dataSource配置的集合
    private Map<String, Map<String, Object>> dataSourceMap = new HashMap<String, Map<String, Object>>();

    @SuppressWarnings("unchecked")
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        try {
            if (!dataSourceMap.isEmpty()){
                for (Entry<String, Map<String,Object>> entry : dataSourceMap.entrySet()){
                    Object type = entry.getValue().get("type");
                    if (null == type){  //获取数据源类型，没有设置为默认数据源
                        type = DATASOURCE_TYPE_DEFAULT;
                    }
                    registerBean(beanDefinitionRegistry,
                            entry.getKey(), (Class<? extends DataSource>)Class.forName(type.toString()));
                }
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.err.println("com.springboot.multipleDataSource.MultipleDataSourceBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
        configurableListableBeanFactory.getBeanDefinition("dataSource").setPrimary(true);
        if (!dataSourceMap.isEmpty()){
            BeanDefinition beanDefinition = null;
            Map<String, Object> dsMap = null;
            MutablePropertyValues mutablePropertyValues = null;
            for (Entry<String,Map<String,Object>> entry:dataSourceMap.entrySet()){
                beanDefinition = configurableListableBeanFactory.getBeanDefinition(entry.getKey());
                mutablePropertyValues = beanDefinition.getPropertyValues();
                dsMap = entry.getValue();
                mutablePropertyValues.addPropertyValue("driverClassName", dsMap.get("driverClassName"));
                mutablePropertyValues.addPropertyValue("url", dsMap.get("url"));
                mutablePropertyValues.addPropertyValue("username", dsMap.get("username"));
                mutablePropertyValues.addPropertyValue("password", dsMap.get("password"));
            }
        }
    }

    /**
     * 重写setEnvironment，是在系统启动后执行，
     * 这个方法主要是加载多数据源配置
     * 从application.properties文件中加载
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        System.err.println("com.springboot.multipleDataSource." +
                "MultipleDataSourceBeanDefinitionRegistryPostProcessor.setEnvironment");
        /**
         * 获取application.properties配置的多数据源配置，添加到map中，
         * 之后在postProcessBeanDefinitionRegistry进行注册。
         */

        // 获取到前缀是"custom.datasource." 的属性列表值.
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "custom.datasource.");
        // 获取到所有数据源的名称.
        String dataSourcePrefixs = propertyResolver.getProperty("names");
        String[] dataSourcePrefixArr = dataSourcePrefixs.split(",");
        for (String dataSourcePrefix : dataSourcePrefixArr){
            /**
             * 获取子属性，对应一个map；
             * 这个map的key就是：type，driver-class-name等
             */
            Map<String, Object> dataSourceMap = propertyResolver.getSubProperties(dataSourcePrefix+".");
            this.dataSourceMap.put(dataSourcePrefix, dataSourceMap);
        }
    }

    /**
     * 注册Bean到Spring
     * @param beanDefinitionRegistry
     * @param name
     * @param beanClass
     */
    private void registerBean(BeanDefinitionRegistry beanDefinitionRegistry, String name, Class<?> beanClass){
        AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition =
                new AnnotatedGenericBeanDefinition(beanClass);
        ScopeMetadata scopeMetadata =
                this.scopeMetadataResolver.resolveScopeMetadata(annotatedGenericBeanDefinition);
        annotatedGenericBeanDefinition.setScope(scopeMetadata.getScopeName());
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(
                annotatedGenericBeanDefinition,beanDefinitionRegistry));
         AnnotationConfigUtils.processCommonDefinitionAnnotations(annotatedGenericBeanDefinition);
        BeanDefinitionHolder beanDefinitionHolder =
                new BeanDefinitionHolder(annotatedGenericBeanDefinition, beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, beanDefinitionRegistry);
    }
}
