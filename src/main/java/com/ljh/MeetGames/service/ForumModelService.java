package com.ljh.MeetGames.service;

import com.ljh.MeetGames.dao.Post;
import com.ljh.MeetGames.dao.Reply;
import com.ljh.MeetGames.mapper.ForumModelMapper;
import com.ljh.MeetGames.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumModelService {
    @Autowired
    ForumModelMapper forumModelMapper;

    public List<Post> allPost(){
        List<Post> posts = forumModelMapper.allPost();
        return posts;
    }

    public Post post(Long postId){
        Post post = forumModelMapper.post(postId);
        return post;
    }

    public List<Reply> reply(Long postId){
        List<Reply> reply = forumModelMapper.reply(postId);
        return  reply;
    }

    public Boolean addPost(String postTitle,String postContent,Long postMaster){
        Snowflake snowflake = new Snowflake(1, 1, 1);
        long postId = snowflake.nextId();
        forumModelMapper.addPost(postId,postTitle,postContent,postMaster);
        return true;
    }

    public Boolean addReply(Long postId,String replyContent,Long replyMaster){
        Snowflake snowflake = new Snowflake(1,1,1);
        long replyId = snowflake.nextId();
        forumModelMapper.addReply(replyId,postId,replyContent,replyMaster);
        return true;
    }

    public Boolean delPost(Long postId){
        forumModelMapper.delPost(postId);
        return true;
    }

    public List<Post> myPost(Long userId){
        List<Post> posts = forumModelMapper.myPost(userId);
        return posts;
    }

    public Boolean delReply(Long replyId){
        forumModelMapper.delReply(replyId);
        return true;
    }
}
