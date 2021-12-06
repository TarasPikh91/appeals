package com.appeals.appeals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping("/loginPage")
    public String login() {
        return "/login";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

    @PostMapping("/login")
    public String loginSuccess() {
        return "/main";
    }
}
