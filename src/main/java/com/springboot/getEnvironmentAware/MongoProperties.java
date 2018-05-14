package com.springboot.getEnvironmentAware;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author MingTie
 * CreateDate：2017/8/15
 * Description：使用@ConfigurationProperties读取application属性配置文件中的属性
 */
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {
    private String host;
    private String strHost = "host";
    private String uri = "mongodb://localhost/test";
    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStrHost() {
        return strHost;
    }

    public void setStrHost(String strHost) {
        this.strHost = strHost;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
