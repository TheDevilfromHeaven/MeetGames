package com.ljh.MeetGames.controller;

import com.github.pagehelper.PageHelper;
import com.ljh.MeetGames.dao.Games;
import com.ljh.MeetGames.dao.Note;
import com.ljh.MeetGames.service.GamesModelService;
import com.ljh.MeetGames.service.WishModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/GamesModel")
public class GamesModelController {
    @Autowired
    GamesModelService gamesModelService;

    @Autowired
    WishModelService wishModelService;

    @RequestMapping("/gameInfo")
    public String gameInfo(HttpSession session,Model model,Long gameId){
        Games games = gamesModelService.games(gameId);
        Long userId = (Long) session.getAttribute("userId");
        if(userId != null){
            Boolean exist = wishModelService.exist(userId, gameId);
            if (exist == true) {
                model.addAttribute("exist","true");
            }else {
                model.addAttribute("exist","false");
            }
        }else {
            model.addAttribute("exist","false");
        }
        String game_id = games.getGame_id().toString();
        model.addAttribute("gameId",game_id);
        model.addAttribute("games",games);
        return "game/gameInfo";
    }

    @RequestMapping("/gamesCenter")
    @ResponseBody
    public Object gamesCenter(Integer Page,String gameName,Model model){
        PageHelper.startPage(Page,16);
        List<Games> games = gamesModelService.gamesCenter(gameName);
        return games;
    }

    @RequestMapping("/findGame")
    @ResponseBody
    public Object findGame(Long gameId){
        Games games = gamesModelService.games(gameId);
        return games;
    }

    @RequestMapping("/addNote")
    @ResponseBody
    public Object addNote(HttpSession session,Long gameId,String noteContent,String Recommend){
        Long userId = (Long) session.getAttribute("userId");
        gamesModelService.addNote(gameId,noteContent,userId,Recommend);
        return true;
    }

    @RequestMapping("/notes")
    @ResponseBody
    public Object notes(Long gameId){
        List<Note> notes = gamesModelService.notes(gameId);
        return notes;
    }

    @RequestMapping("/updateGameInfo")
    @ResponseBody
    public Object updateGameInfo(Long gameId,String gameName,String introduction){
        gamesModelService.updateGameInfo(gameId,gameName,introduction);
        return true;
    }

    @RequestMapping("/deleteGame")
    @ResponseBody
    public Object deleteGame(Long gameId){
        gamesModelService.deleteGame(gameId);
        return true;
    }
}
