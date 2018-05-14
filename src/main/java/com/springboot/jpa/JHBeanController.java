package com.springboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MingT on 2017/7/12.
 */
@RestController
@RequestMapping("/JH")
public class JHBeanController {

    private JHBeanService jhBeanService;

    @Autowired
    public void setJhBeanService(JHBeanService jhBeanService) {
        this.jhBeanService = jhBeanService;
    }

    @RequestMapping("/save/{name}")
    // URL:http://localhost:8080/JH/save/YJ
    public JHBean save(@PathVariable String name) {
        JHBean jhBean = new JHBean();
        jhBean.setName(name);
        jhBeanService.save(jhBean);
        return jhBean;
    }
}
