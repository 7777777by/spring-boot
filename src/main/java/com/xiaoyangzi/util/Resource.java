package com.xiaoyangzi.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: liuyang
 * @Date: 20180430 12:12
 */
@Configuration
@ConfigurationProperties(prefix = "com.xiaoyangzi.opensource")
@PropertySource(value = "classpath:resource.propertity")
public class Resource {
    private String name;
    private Integer age;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
