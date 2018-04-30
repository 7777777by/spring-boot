package com.xiaoyangzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liuyang
 * @Date: 20180430 17:52
 */
@Controller
@RequestMapping("/err")
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        int a = 1 / 0;
        return "thymeleaf/error";
    }
}
