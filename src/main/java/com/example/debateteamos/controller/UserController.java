package com.example.debateteamos.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.debateteamos.entity.UserInfo;
import com.example.debateteamos.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Queue;

@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String checkLogin(UserInfo user, HttpServletRequest request){
        QueryWrapper<UserInfo> userWrapper = new QueryWrapper();
        UserInfo rightUser = loginService.getOne(userWrapper.eq("username", user.getUsername()));
        if (user.getPassword().equals(rightUser.getPassword())) {
            System.out.println("right");
            return "user";
        } else {
            System.out.println("wrong");
            request.setAttribute("msg", "Wrong username or password!");
            return "login";
        }
    }
}
