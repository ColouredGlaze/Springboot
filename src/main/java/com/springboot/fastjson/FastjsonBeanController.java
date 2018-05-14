package com.springboot.fastjson;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MingT on 2017/7/12.
 */
@RestController
@RequestMapping("/FastJson")
public class FastjsonBeanController {

    @RequestMapping("/getData/{id}/{name}")
    // url:http://localhost:8080/FastJson/getData/3/zhangsan
    public FastjsonBean getFastJsonData(@PathVariable int id, @PathVariable String name) {
        FastjsonBean fastjsonBean = new FastjsonBean();
        fastjsonBean.setId(id);
        fastjsonBean.setName("没有ID表示FastJson配置成功"+name);
        return fastjsonBean;
    }
}
