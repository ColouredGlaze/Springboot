package com.springboot.multipleDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MingTie
 * CreateDate：2017/9/3
 * Description：多数据源Controller
 */
@RestController
@RequestMapping("MultipleDataSourceController")
public class MultipleDataSourceController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("ds1")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("ds2")
    private DataSource dataSource2;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        System.out.println("MultipleDataSourceController.setJdbcTemplate()");
        jdbcTemplate.setDataSource(dataSource2);//设置dataSource
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("soutDs1")
    public String soutDs1(){
        System.err.println(dataSource1);
        return "soutDs1";
    }


    @RequestMapping("soutDs2")
    public String soutDs2(){
        System.err.println(dataSource2);
        return "soutDs2";
    }

    @RequestMapping("query1")
    public String query1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1);
        System.err.println(jdbcTemplate.getDataSource());
        System.err.println(jdbcTemplate);
        String sql = "SELECT * FROM ds1_user";
        jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                System.err.println("id："+resultSet.getInt("id")+"\r\nname："+resultSet.getString("name")+"\r\npassword："+resultSet.getString("password"));
                return "";
            }
        });
        return "query1";
    }

    @RequestMapping("query2")
    public String query2(){
        System.err.println(jdbcTemplate.getDataSource());
        System.err.println(jdbcTemplate);
        String sql = "SELECT * FROM ds1_user";
        jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                System.err.println("id："+resultSet.getInt("id")+"\r\nname："+resultSet.getString("name")+"\r\npassword："+resultSet.getString("password"));
                return "";
            }
        });
        return "query2";
    }
}
