package com.springboot.redisCache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * @author MingTie
 * CreateDate：2017/8/27
 * Description：Redis缓存配置
 */
@Configuration
// 启用缓存
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        RedisSerializer<?> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        return redisTemplate;
    }

    @Override
    public KeyGenerator keyGenerator() {
        System.err.println("com.springboot.redisCache.RedisCacheConfig.keyGenerator()");
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append("ClassName : ");
                sb.append(o.getClass().getName());
                sb.append("+++MethodName : ");
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append("+++Object : ");
                    sb.append(obj.toString());
                }
                System.err.println("KeyGenerator = " + sb.toString());
                return sb.toString();
            }
        };
    }
}
