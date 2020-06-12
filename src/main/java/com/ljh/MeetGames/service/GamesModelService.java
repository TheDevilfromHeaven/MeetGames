package com.ljh.MeetGames.service;

import com.ljh.MeetGames.dao.Games;
import com.ljh.MeetGames.dao.Note;
import com.ljh.MeetGames.mapper.GamesModelMapper;
import com.ljh.MeetGames.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesModelService {
    @Autowired
    GamesModelMapper gamesModelMapper;

    public List<Games> allGames(){
        List<Games> games = gamesModelMapper.allGames();
        return games;
    }

    public List<Games> gamesCenter(String gameName){
        List<Games> games = gamesModelMapper.gamesCenter(gameName);
        return games;
    }

    public Games games(Long gameId){
        Games game = gamesModelMapper.game(gameId);
        return game;
    }

    public Boolean addNote(Long gameId,String noteContent,Long noteMaster,String Recommend){
        Snowflake snowflake = new Snowflake(1,1,1);
        long noteId = snowflake.nextId();
        Note note = new Note();
        note.setNote_id(noteId);
        note.setGame_id(gameId);
        note.setNote_content(noteContent);
        note.setNote_master(noteMaster);
        note.setRecommend(Recommend);
        gamesModelMapper.addNote(note);
        return true;
    }

    public List<Note> notes(Long gameId){
        List<Note> notes = gamesModelMapper.notes(gameId);
        return notes;
    }

    public Boolean updateGameInfo(Long gameId,String gameName,String introduction){
        gamesModelMapper.updateGameInfo(gameId,gameName,introduction);
        return true;
    }

    public Boolean deleteGame(Long gameId){
        gamesModelMapper.deleteGame(gameId);
        return true;
    }
}
