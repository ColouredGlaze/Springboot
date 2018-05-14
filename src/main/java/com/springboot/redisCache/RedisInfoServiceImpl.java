package com.springboot.redisCache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/27
 * Description：
 */
@Service
public class RedisInfoServiceImpl implements RedisInfoService{

    @Resource
    private RedisInfoRepository redisInfoRepository;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(value = "redisInfo")
    public RedisInfo findById(long id) {
        System.err.println("com.springboot.redisCache.RedisInfoServiceImpl.findById()" +
                "===从数据库中获取RedisInfo : id ="+id);
        return redisInfoRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = "redisInfo")
    public void deleteBidInfoFromCacheById(long id) {
        System.err.println("com.springboot.redisCache.RedisInfoServiceImpl.deleteBidInfoFromCacheById()" +
                "===从缓存中删除" + id);
        redisTemplate.delete("ClassName : com.springboot.redisCache.RedisInfoServiceImpl" +
                "+++MethodName : findById" +
                "+++Object : "+id);
    }

    @Override
    public void test() {
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myKey", "random = "+Math.random());
        System.err.println("com.springboot.redisCache.RedisInfoServiceImpl.test()+" + valueOperations.get("myKey"));
    }
}
