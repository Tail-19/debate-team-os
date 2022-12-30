package com.example.debateteamos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.debateteamos.model.StoredFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FileMapper extends BaseMapper<StoredFile> {
    @Select("select * from files")
    List<StoredFile> selectAll();

    @Select("select * from files where id = #{id}")
    StoredFile selectById(int id);

    @Insert("insert into files(name,path,fileType,uploader,uploaderTitle,tag) " +
            "values (#{name},#{path},#{fileType},#{uploader},#{uploaderTitle},#{tag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StoredFile file);

    @Delete("delete from files where id = #{id}")
    int deleteById(int id);

    @Update("update files set tag = #{tag} where id = #{id}")
    int updateTagById(int id, String newTag);

    @Select("select * from files where name like '%${str}%'")
    List<StoredFile> selectByStr(String str);
}
