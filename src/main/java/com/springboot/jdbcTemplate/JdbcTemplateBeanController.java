package com.springboot.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MingT on 2017/7/12.
 */
@RestController
@RequestMapping("/JdbcTemplate")
public class JdbcTemplateBeanController {

    @Autowired
    private JdbcTemplateBeanService jdbcTemplateBeanService;

    @RequestMapping("/findById")
    // URL:http://localhost:8080/JdbcTemplate/findById?id=3
    public JdbcTemplateBean findById(long id) {
        return jdbcTemplateBeanService.getById(id);
    }
}
