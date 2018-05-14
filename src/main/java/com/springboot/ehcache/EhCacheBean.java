package com.springboot.ehcache;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author MingTie
 * CreateDate：2017/8/31
 * Description：ehcache缓存测试实体类
 */
@Entity
public class EhCacheBean {
    @Id@GeneratedValue
    private Long id;
    private String name;
    private String pwd;
    private int state;

    @Override
    public String toString() {
        return "EhCacheBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
