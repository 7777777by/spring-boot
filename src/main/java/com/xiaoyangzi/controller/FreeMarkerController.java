package com.xiaoyangzi.controller;

import com.xiaoyangzi.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: liuyang
 * @Date: 20180430 14:31
 */
@Controller
@RequestMapping("/ftl")
public class FreeMarkerController {
    @Autowired
    private Resource resource;

    @RequestMapping("/index")
    public String inde(ModelMap map){
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping("/center")
    public String center(){
        return "freemarker/center/center";
    }
}
