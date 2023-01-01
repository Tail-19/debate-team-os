package com.example.debateteamos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.debateteamos.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MessageMapper extends BaseMapper<Message> {
    @Select("select * from messages where name like '%${toName}%'")
    public List<Message> selectByName(String toName);

    @Insert("insert into messages(from,to,message) " +
            "values (#{from},#{to},#{msg)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int sendMsg(String from,String to,String msg);


}
