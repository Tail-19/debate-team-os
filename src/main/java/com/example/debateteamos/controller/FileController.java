package com.example.debateteamos.controller;

import com.example.debateteamos.mapper.FileMapper;
import com.example.debateteamos.model.StoredFile;
import com.example.debateteamos.service.IFileService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/file/api")
public class FileController {
    @Resource
    FileMapper fileMapper;

    //绑定文件上传路径到uploadPath
    @Value("${file.location}")
    private String uploadPath;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/upload")
    public String upload(@RequestParam("filename") String filename,
                         @RequestParam("select") String select,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request,
                         @CookieValue(value = "token", required = false) String cookie
    ) throws IOException {

        // 在 uploadPath 文件夹中通过日期对上传的文件归类保存
        // 比如：/2019/06/06/cf13891e-4b95-4000-81eb-b6d70ae44930.png
        String format = sdf.format(new Date());
        String newName;
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        if (file == null) {
            System.out.println("Null!");
            return "bad";
        }
        // 对上传的文件重命名，避免文件重名
        String oldName = file.getOriginalFilename();
        newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."));
        try {
            // 文件保存
            file.transferTo(new File(folder, newName));


        } catch (IOException e) {
            throw e;
        }

        // 数据库操作
        StoredFile storedFile = new StoredFile();
        storedFile.name = filename;
        storedFile.fileType = oldName.substring(oldName.lastIndexOf("."));

        // TODO: 使用cookie确认上传者信息
        storedFile.uploader = "None";
        storedFile.uploaderTitle = "None";
        storedFile.path = uploadPath + format + newName;
        storedFile.tag = select;

        fileMapper.insert(storedFile);
        System.out.println("Stored file at " + storedFile.path);
        return "ok";
    }
}


