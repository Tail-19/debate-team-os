package com.example.debateteamos.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.debateteamos.mapper.FileMapper;
import com.example.debateteamos.model.StoredFile;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FilePageController {
    @Resource()
    FileMapper fileMapper;

    @GetMapping
    public String index(Model model,@RequestParam(required = false) String content) {
        List<StoredFile> f;
        if(content == null) {
            f = fileMapper.selectAll();
        } else {
            f = fileMapper.selectByStr(content);
        }
        model.addAttribute("files", f);
        return "fileList";
    }

    @GetMapping("/api/del")
    public String delFile(@RequestParam int id) {
        StoredFile fd = fileMapper.selectById(id);
        File file = new File(fd.path);
        file.delete();
        fileMapper.deleteById(id);
        return "redirect:/file";
    }

    // 代码量不大 不做业务分离了
    @GetMapping("/api/down")
    public String download(HttpServletResponse response, @RequestParam int id) {
        try {
            StoredFile fd = fileMapper.selectById(id);
            if (fd == null) {
                return "redirect:/file";
            }
            // path是指想要下载的文件的路径
            File file = new File(fd.path);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "redirect:/file";
    }

    @GetMapping("/search")
    public String search(@RequestParam String content, ModelMap model) {
        List<StoredFile> fs = fileMapper.selectByStr(content);
        System.out.println(fs.size());

        model.addAttribute("files",fs);
        return "fileList";
    }
}
