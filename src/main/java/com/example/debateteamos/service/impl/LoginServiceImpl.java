package com.example.debateteamos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.debateteamos.entity.UserInfo;
import com.example.debateteamos.mapper.LoginMapper;
import com.example.debateteamos.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, UserInfo> implements LoginService {
}
