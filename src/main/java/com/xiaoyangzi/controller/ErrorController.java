package com.xiaoyangzi.controller;

import com.xiaoyangzi.util.LiuJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/ajaxerror")
    public String ajaxerror(){
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxError")
    @ResponseBody
    public LiuJSONResult getAjaxError(){
        int a = 1 / 0;
        return LiuJSONResult.ok();
    }
}
