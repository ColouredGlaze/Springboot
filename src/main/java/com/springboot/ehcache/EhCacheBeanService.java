package com.springboot.ehcache;

/**
 * @author MingTie
 * CreateDate：2017/8/31
 * Description：
 */
public interface EhCacheBeanService {
    void delete(Long id);
    EhCacheBean update(EhCacheBean ehCacheBean);
    EhCacheBean findById(Long id);
    EhCacheBean save(EhCacheBean ehCacheBean);
}
