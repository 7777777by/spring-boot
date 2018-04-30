package com.xiaoyangzi.controller;

import com.xiaoyangzi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: liuyang
 * @Date: 20180430 14:52
 */
@Controller
@RequestMapping("/th")
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-xiaoyangzi");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap map){
        User user = new User();
        user.setName("xiaoyangzi");
        user.setPassword("123456");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello xiaoyangzi</b></font>");
        User user1 = new User();
        user1.setName("feifei");
        user1.setPassword("123456");
        user1.setAge(18);
        user1.setBirthday(new Date());
        user1.setDesc("<font color='green'><b>hello feifei</b></font>");
        User user2 = new User();
        user2.setName("jinger");
        user2.setPassword("123456");
        user2.setAge(18);
        user2.setBirthday(new Date());
        user2.setDesc("<font color='green'><b>hello jinger</b></font>");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        map.addAttribute("user", user);
        map.addAttribute("userList", userList);
        return "thymeleaf/test";
    }

    @RequestMapping("/postform")
    public String postform(User user){
        System.out.println(user.getName());
        return "redirect:/th/test";
    }

    @RequestMapping("/showerror")
    public String showerror(User user){
        int a = 1 / 0;
        return "redirect:/th/test";
    }
}
