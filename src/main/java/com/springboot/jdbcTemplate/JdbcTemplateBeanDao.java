package com.springboot.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by MingT on 2017/7/12.
 */
@Repository
public class JdbcTemplateBeanDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateBean getById(long id) {
        String sql = "select * from jdbctemplate where id = ?";
        RowMapper<JdbcTemplateBean> rowMapper = new BeanPropertyRowMapper<JdbcTemplateBean>(JdbcTemplateBean.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
