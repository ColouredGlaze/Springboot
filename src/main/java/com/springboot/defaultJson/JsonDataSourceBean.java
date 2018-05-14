package com.springboot.defaultJson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by MingT on 2017/7/11.
 */
public class JsonDataSourceBean {
    private long id;
    private String name;
    /**
     * 使用默认的JSON格式化日期：
     * @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
     */
    //使用fastJson格式化日期：
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
