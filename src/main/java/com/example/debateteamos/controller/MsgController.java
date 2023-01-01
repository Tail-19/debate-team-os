package com.example.debateteamos.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.debateteamos.entity.Message;
import com.example.debateteamos.entity.UserInfo;
import com.example.debateteamos.mapper.LoginMapper;
import com.example.debateteamos.mapper.MessageMapper;
import com.example.debateteamos.service.LoginService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    LoginService loginService;

    @Resource
    LoginMapper loginMapper;

    @Resource
    MessageMapper messageMapper;

    @RequestMapping("/send")
    public void send(@RequestParam String content,@RequestParam String sendTo,
                     @CookieValue(value = "token", required = true) String token) {
        Message msg = new Message();
        QueryWrapper<UserInfo> userWrapper = new QueryWrapper();
        UserInfo rightUser = loginService.getOne(userWrapper.eq("token", token));
        msg.setFrom(rightUser.getUsername());
        msg.setTo(sendTo);
        msg.setMessage(content);

        // 投递邮件
        messageMapper.insert(msg);
    }

    @RequestMapping("/get")
    public ModelAndView get(@CookieValue(value = "token", required = true) String token) {

        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = loginMapper.fillMailBox(token);

        // 构建返回值
        for(UserInfo u : users ) {
            for(Message m : u.getMsgs()) {
                mv.addObject("msg"+m.getId(),m.getMessage());
            }
        }

        return mv;
    }
}
