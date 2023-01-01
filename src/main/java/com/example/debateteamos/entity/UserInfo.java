package com.example.debateteamos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@TableName("userTable")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private int id;

    private String username;
    private String student_id;
    private String password;
    private String phone;
    private String email;
    private String token;
}
