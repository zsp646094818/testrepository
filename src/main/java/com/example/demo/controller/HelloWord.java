package com.example.demo.controller;

import com.example.demo.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloWord {

    @Autowired
    protected IUserService userService2;

    @RequestMapping("/hello")
    public String HelloWord() {
        return "Hello Word";
    }

    @RequestMapping("/test")
    public String Test() {
        return userService2.GetUserInfo();
    }


}
