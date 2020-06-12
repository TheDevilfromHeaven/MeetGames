package com.ljh.MeetGames.controller;

import com.ljh.MeetGames.dao.Wish;
import com.ljh.MeetGames.service.WishModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/WishModel")
public class WishModelController {
    @Autowired
    WishModelService wishModelService;

    @RequestMapping("/addWish")
    @ResponseBody
    public Object addWish(HttpSession session,Long gameId){
        Long userId = (Long) session.getAttribute("userId");
        if(userId != null){
            wishModelService.addWish(userId,gameId);
            return true;
        }
        return false;
    }

    @RequestMapping("/removeWish")
    @ResponseBody
    public Object removeWish(HttpSession session,Long gameId){
        Long userId = (Long) session.getAttribute("userId");
        Boolean result = wishModelService.removeWish(userId, gameId);
        if(result == true) {
            return true;
        }
        return false;
    }
}
