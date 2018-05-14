package com.springboot.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MingT on 2017/7/12.
 */
@Service
public class JdbcTemplateBeanService {
    @Autowired
    private JdbcTemplateBeanDao jdbcTemplateBeanDao;

    public JdbcTemplateBean getById(long id){
        return jdbcTemplateBeanDao.getById(id);
    }
}
