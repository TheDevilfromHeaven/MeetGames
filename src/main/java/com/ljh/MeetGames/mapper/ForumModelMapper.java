package com.ljh.MeetGames.mapper;

import com.ljh.MeetGames.dao.Post;
import com.ljh.MeetGames.dao.Reply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ForumModelMapper {
    @Select("select post.*,userinfo.user_name from post "
            + "left join userinfo "
            + "on post.post_master = userinfo.user_id "
            + "order by post.post_id desc")
    List<Post> allPost();

    @Select("select post.*,userinfo.user_name,userinfo.user_head from post "
            + "left join userinfo "
            + "on post.post_master = userinfo.user_id "
            + "where post_id = #{postId}")
    Post post(Long postId);

    @Select("select reply.*,userinfo.user_name,userinfo.user_head from reply "
            + "left join userinfo "
            + "on reply.reply_master = userinfo.user_id "
            + "where post_id = #{postId} "
            + "order by reply.reply_id")
    List<Reply> reply(Long postId);

    @Insert("insert into post(post_id,post_title,post_content,post_master) values (#{postId},#{postTitle},#{postContent},${postMaster})")
    Boolean addPost(Long postId,String postTitle,String postContent,Long postMaster);

    @Insert("insert into reply(reply_id,post_id,reply_content,reply_master) values (#{replyId},#{postId},#{replyContent},#{replyMaster})")
    Boolean addReply(Long replyId,Long postId,String replyContent,Long replyMaster);

    @Delete("delete from post where post_id = #{postId}")
    Boolean delPost(Long postId);

    @Select("select * from post where post_master = #{userId}")
    List<Post> myPost(Long userId);

    @Delete("delete from reply where reply_id = #{replyId}")
    Boolean delReply(Long replyId);
}
