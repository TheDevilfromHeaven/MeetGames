package com.ljh.MeetGames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class welcome {
    @RequestMapping({"/hello"})
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "oauth/github";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
