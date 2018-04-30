package com.xiaoyangzi.controller;

import com.xiaoyangzi.util.LiuJSONResult;
import com.xiaoyangzi.util.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liuyang
 * @Date: 20180421 21:00
 */
@RestController
public class HelloController {
    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public String hello() {
        return "hello springboot~~";
    }

    @RequestMapping("/getResource")
    public LiuJSONResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return LiuJSONResult.ok(bean);
    }
}
