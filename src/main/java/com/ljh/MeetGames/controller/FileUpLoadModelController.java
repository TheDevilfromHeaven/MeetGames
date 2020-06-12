package com.ljh.MeetGames.controller;

import com.ljh.MeetGames.mapper.UserModelMapper;
import com.ljh.MeetGames.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/FileUpLoadModel")
public class FileUpLoadModelController {
    @Autowired
    UserModelService userModelService;

    @RequestMapping("/uploadHead")
    public String uploadHead(MultipartFile file, HttpSession session){
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
            String format = date.format(new Date());
            String fileName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."), fileName.length());
            String filePath = "E://github//MeetGames//src//main//resources//static//img//heads//";
            String path = filePath + newName;
            File dest = new File(path);
            file.transferTo(dest);
            String sqlPath = "/img/heads/" + newName;
            Long userId = (Long) session.getAttribute("userId");
            userModelService.updateHeadImg(sqlPath,userId);
            return "redirect:/UserModel/userInfo/headImg";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}
