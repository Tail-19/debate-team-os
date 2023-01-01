package com.example.debateteamos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Message {
    @TableId(type = IdType.AUTO)
    private int id;

    private String from;
    private String to;
    private String message;
}
