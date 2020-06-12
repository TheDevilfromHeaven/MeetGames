package com.ljh.MeetGames.mapper;

import com.ljh.MeetGames.dao.Games;
import com.ljh.MeetGames.dao.Note;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GamesModelMapper {
    @Select("<script>"
            + "select * from games"
            + "<if test='gameName != null and gameName != \"\"'> where game_name like concat('%',#{gameName},'%')</if></script>")
    List<Games> gamesCenter(String gameName);

    @Select("select * from games")
    List<Games> allGames();

    @Select("select * from games where game_id = ${gameId}")
    Games game(Long gameId);

    @Insert("insert into note(note_id,game_id,note_content,note_master,recommend) values (#{note_id},#{game_id},#{note_content},#{note_master},#{recommend})")
    Boolean addNote(Note note);

    @Select("select note.*,userinfo.user_name,userinfo.user_head from note " +
            "left join userinfo " +
            "on note.note_master = userinfo.user_id " +
            "where game_id = #{gameId}")
    List<Note> notes(Long gameId);

    @Update("update games set game_name = #{gameName},introduction = #{introduction} where game_id = #{gameId}")
    Boolean updateGameInfo(Long gameId,String gameName,String introduction);

    @Delete("delete from games where game_id = #{gameId}")
    Boolean deleteGame(Long gameId);
}
