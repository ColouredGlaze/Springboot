package com.springboot.useCustomProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：访问在application.properties中自定义的属性
 */
@ConfigurationProperties(prefix = "quite")
public class QuiteSetting {

    private String name;
    private String password;

    @Override
    public String toString() {
        return "QuiteSetting{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
