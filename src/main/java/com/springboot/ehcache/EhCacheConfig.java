package com.springboot.ehcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author MingTie
 * CreateDate：2017/8/28
 * Description：EhCache缓存配置
 */
//@Configuration
//@EnableCaching // 标注启动缓存
public class EhCacheConfig {

//    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        System.err.println("com.springboot.ehcache.EhCacheConfig.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        /**
         * 根据shared与否的设置，
         * Spring分别通过CacheManager.create()
         * 或者new CacheManager() 方式来创建一个ehcache仓库
         * 也就是说通过这个shared的设置来决定该ehcache仓库是这里的Spring独用，还是
         * 跟其他的（如hibernate的Ehcache共享）
         */
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

    // 主要的管理器
//    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean){
        System.err.println("com.springboot.ehcache.EhCacheConfig.ehCacheCacheManager()");
        return new EhCacheCacheManager(ehCacheManagerFactoryBean.getObject());
    }


}
