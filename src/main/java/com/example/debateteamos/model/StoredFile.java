package com.example.debateteamos.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class StoredFile {
    @TableId(type = IdType.AUTO)
    public Long id;
    public String name;
    public String path;
    public String fileType;
    public String uploader;
    public String uploaderTitle;
    public String tag;
}
