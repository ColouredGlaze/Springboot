package com.springboot.fastjson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by MingT on 2017/7/12.
 */
public class FastjsonBean {

    @JSONField(serialize = false)
    private long id;
    private String name;

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
