package com.ljh.MeetGames.controller;

import com.ljh.MeetGames.dao.Games;
import com.ljh.MeetGames.service.GamesModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class defaultController {
    @Autowired
    GamesModelService gamesModelService;

    @RequestMapping({"","/index"})
    public String defaultLink(Model model){
        List<Games> gamesList = gamesModelService.allGames();
        model.addAttribute("gamesList",gamesList);
        return "index";
    }
}
