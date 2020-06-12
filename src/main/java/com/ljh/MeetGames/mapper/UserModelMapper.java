package com.ljh.MeetGames.mapper;

import com.ljh.MeetGames.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserModelMapper {
    @Select("select * from login where login_name = #{loginName}")
    User login(String loginName);

    @Insert("insert into login(user_id,login_name,password) values (#{userId},#{loginName},#{password})")
    Boolean register(Long userId,String loginName,String password);

    @Select("select * from userinfo where user_id = #{userId}")
    User userInfo(Long userId);

    @Insert("insert into userinfo(user_id,user_name) values (#{userId},#{userName})")
    Boolean addInfo(Long userId,String userName);

    @Update("update userinfo set user_head = #{headImg} where user_id = #{userId}")
    Boolean updateHeadImg(String headImg,Long userId);

    @Update("<script>"
            + "update userinfo"
            + "<set> user_name = #{user_name} "
            + "<if test='sex != null and sex != \"\"'>,sex = #{sex}</if>"
            + "<if test='birthday != null and birthday != \"\"'>,birthday = #{birthday}</if>"
            + "<if test='email != null and email != \"\"'>,email = #{email}</if>"
            + "<if test='autograph != null and autograph != \"\"'>,autograph = #{autograph}</if>"
            + "</set>where user_id = #{user_id} </script>")
    Boolean changeInfo(User userinfo);
}
