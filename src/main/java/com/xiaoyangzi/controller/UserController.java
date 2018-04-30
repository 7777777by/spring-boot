package com.xiaoyangzi.controller;

import com.xiaoyangzi.pojo.User;
import com.xiaoyangzi.util.LiuJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: liuyang
 * @Date: 20180421 21:00
 */
//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("xiaoyangzi");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("xiaoyangzi");
        user.setDesc("hello xiaoyangzi!!");
        return user;
    }

    @RequestMapping("/getUserJson")
    public LiuJSONResult getUserJson() {
        User user = new User();
        user.setName("xiaoyangzi~~~~~~~~");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("xiaoyangzi");
        return LiuJSONResult.ok(user);
    }
}
