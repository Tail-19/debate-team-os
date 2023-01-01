package com.example.debateteamos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.debateteamos.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LoginMapper extends BaseMapper<UserInfo> {
   /* @Select("select * from usertable where token = #{token}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "message",column = "username",
                    javaType = List.class,
                    many = @Many(select = "com.example.debateteamos.mapper.MessageMapper.selectByName"))
    })
    public List<UserInfo> fillMailBox(String token);*/
}
