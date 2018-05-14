package com.springboot.crud;

import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by MingT on 2017/7/17.
 */
@Entity
public class CRUDBean {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    @JSONField(format = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE")
    private Date birthday;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
