package com.example.debateteamos.controller;

import com.example.debateteamos.model.StoredFile;
import com.example.debateteamos.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class FilePageController {
    @Autowired
    IFileService fileService;

    @GetMapping
    public  String index(Model model){
        StoredFile f = new StoredFile();
        f.name = "百年孤独";
        StoredFile[] fs = {f};
        model.addAttribute("files", fs);
        return "fileList";
    }

    @GetMapping("/refreshData")
    public String fillTable(Model model) {
        StoredFile f = new StoredFile();
        f.name = "百年不孤独";
        StoredFile[] fs = {f};
        model.addAttribute("files", fs);
        return "redirect:fileList";
    }

    @GetMapping("/api/del")
    public String delFile(@RequestParam Long id) {
        fileService.removeById(id);

        return "redirect:/";
    }
}
