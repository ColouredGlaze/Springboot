package com.springboot.useCustomProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：访问新的配置文件中的属性
 */
@Component
@ConfigurationProperties(prefix = "silence")
//@PropertySource("silence.properties")
public class SilenceSetting {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "SilenceSetting{" +
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
