package com.example.debateteamos.controller;

import com.example.debateteamos.entity.UserInfo;
import com.example.debateteamos.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public String implRegister(UserInfo user, HttpServletRequest request){
        loginService.save(user);
        request.setAttribute("msg", "Register Success!");
        return "redirect:/login";
    }
}
