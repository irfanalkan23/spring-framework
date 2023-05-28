package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){
//        return "userinfo.html";   // means; go to "static" folder and look for userinfo.html
        return "user/userinfo.html";
    }
}
