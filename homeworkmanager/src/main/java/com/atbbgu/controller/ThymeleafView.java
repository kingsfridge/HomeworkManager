package com.atbbgu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pages")
public class ThymeleafView {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "stuPages/login";
    }

    @RequestMapping("/regist")
    public String regist(){
        return "stuPages/regist";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(){
        return "stuPages/updateInfo";
    }

    @RequestMapping("/information")
    public String showInformation(){
        return "stuPages/information";
    }

    @RequestMapping("/createStudyGroup")
    public String toCreatePages(){
        return "stuPages/createStudyGroup";
    }

    @RequestMapping("/stuIndex")
    public String toStuIndex(){
        return "stuPages/stuIndex";
    }

    @RequestMapping("/showStudyGroups")
    public String showStudyGroups(){
        return "stuPages/showStudyGroups";
    }
}
