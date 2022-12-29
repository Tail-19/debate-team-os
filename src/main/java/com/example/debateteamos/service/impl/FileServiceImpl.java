package com.example.debateteamos.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.debateteamos.mapper.FileMapper;
import com.example.debateteamos.model.StoredFile;
import com.example.debateteamos.service.IFileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, StoredFile> implements IFileService {

}
