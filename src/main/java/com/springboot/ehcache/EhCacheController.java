package com.springboot.ehcache;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/31
 * Description：
 */
@RestController
@RequestMapping("/ehcache")
public class EhCacheController {

    @Resource
    private EhCacheBeanService ehCacheBeanService;

    @RequestMapping("/test")
    public String test(){
        EhCacheBean ehCacheBean = new EhCacheBean();
        ehCacheBean.setName("第一条");
        ehCacheBean.setPwd("123456789");
        ehCacheBeanService.save(ehCacheBean);
        // 查询走缓存
        System.err.println("查询走缓存---");
        System.err.println(ehCacheBeanService.findById(ehCacheBean.getId()));
        // 查询不走缓存
        System.err.println("查询不走缓存---");
        System.err.println(ehCacheBeanService.findById(ehCacheBean.getId()));

        ehCacheBean = new EhCacheBean();
        ehCacheBean.setName("第二条");
        ehCacheBean.setPwd("1234567890");
        ehCacheBeanService.save(ehCacheBean);
        // 查询走缓存
        System.err.println("查询走缓存---");
        System.err.println(ehCacheBeanService.findById(ehCacheBean.getId()));
        // 查询不走缓存
        System.err.println("查询不走缓存---");
        System.err.println(ehCacheBeanService.findById(ehCacheBean.getId()));

        // 修改数据
        EhCacheBean update = new EhCacheBean();
        update.setName("第二条+update");
        update.setPwd("0987654321");
        update.setId(ehCacheBean.getId());
        ehCacheBeanService.update(update);
        // 不走缓存
        System.err.println("查询不走缓存---");
        System.err.println(ehCacheBeanService.findById(update.getId()));

        return "finish";
    }
}
