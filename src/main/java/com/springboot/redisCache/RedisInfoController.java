package com.springboot.redisCache;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author MingTie
 * CreateDate：2017/8/27
 * Description：
 */
@RestController
@RequestMapping("/Redis")
public class RedisInfoController {

    @Resource
    private RedisInfoService redisInfoService;

    @RequestMapping("/find")
    public String find(){
        RedisInfo redisInfo = redisInfoService.findById(1);
        System.err.println("loaded : " + redisInfo);
        RedisInfo cache = redisInfoService.findById(1);
        System.err.println("cached : " + cache);
        redisInfo = redisInfoService.findById(2);
        System.err.println("loaded : " + redisInfo);
        return "com.springboot.redisCache.RedisInfoController.find()";
    }

    @RequestMapping("/delete")
    public String delete(long id){
        redisInfoService.deleteBidInfoFromCacheById(id);
        return"com.springboot.redisCache.RedisInfoController.delete()";
    }

    @RequestMapping("/test")
    public String test(){
        redisInfoService.test();
        System.err.println("com.springboot.redisCache.RedisInfoController.test()");
        return "com.springboot.redisCache.RedisInfoController.test()";
    }

}
