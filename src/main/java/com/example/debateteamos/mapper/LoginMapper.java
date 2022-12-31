package com.example.debateteamos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.debateteamos.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LoginMapper extends BaseMapper<UserInfo> {
}
