package com.springboot.redisCache;


/**
 * @author MingTie
 * CreateDate：2017/8/27
 * Description：
 */
public interface RedisInfoService {

    RedisInfo findById(long id);
    void deleteBidInfoFromCacheById(long id);
    void test();
}
