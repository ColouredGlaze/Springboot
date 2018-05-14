package com.springboot.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by MingT on 2017/7/12.
 */
// 加入@Entity注解，自动将Bean进行持久化
@Entity
// 可自定义@Table进行配置
public class JHBean {
    @Id
    @GeneratedValue
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

    @Override
    public String toString() {
        return "JHBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
