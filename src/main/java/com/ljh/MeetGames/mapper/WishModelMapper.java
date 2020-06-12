package com.ljh.MeetGames.mapper;

import com.ljh.MeetGames.dao.Wish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WishModelMapper {
    @Select("select * from wish where user_id = #{userId} and game_id = #{gameId}")
    Wish exist(Long userId,Long gameId);

    @Insert("insert into wish(user_id,game_id) values (#{userId},#{gameId})")
    Boolean addWish(Long userId,Long gameId);

    @Select("select wish.*,games.game_name,games.game_img_mini from wish "
            + "left join games "
            + "on wish.game_id = games.game_id "
            + "where user_id = #{userId} ")
    List<Wish> wishList(Long userId);

    @Delete("delete from wish where user_id = ${userId} and game_id = ${gameId}")
    Boolean removeWish(Long userId,Long gameId);
}
