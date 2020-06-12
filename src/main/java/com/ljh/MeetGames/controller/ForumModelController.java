package com.ljh.MeetGames.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljh.MeetGames.dao.Post;
import com.ljh.MeetGames.dao.Reply;
import com.ljh.MeetGames.service.ForumModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ForumModel")
public class ForumModelController {
    @Autowired
    ForumModelService forumModelService;

    @RequestMapping("/forum")
    public String forum(Model model,HttpSession session,@RequestParam(defaultValue="1") Integer Page){
        List<Post> postList = forumModelService.allPost();
        PageHelper.startPage(Page,10);
        List<Post> posts = forumModelService.allPost();
        PageInfo<Post> PageInfo = new PageInfo<>(posts);
        model.addAttribute("posts",posts);
        model.addAttribute("postList",postList);
        model.addAttribute("PageInfo",PageInfo);
        return "/forum/forum";
    }

    @RequestMapping("/post")
    public String post(Model model,Long postId,HttpSession session,@RequestParam(defaultValue="1") Integer Page){
        Post post = forumModelService.post(postId);
        List<Post> postList = forumModelService.allPost();
        PageHelper.startPage(Page,10);
        List<Reply> reply = forumModelService.reply(postId);
        PageInfo<Reply> PageInfo = new PageInfo<>(reply);
        String post_id = post.getPost_id().toString();
        model.addAttribute("postId",post_id);
        model.addAttribute("post",post);
        model.addAttribute("postList",postList);
        model.addAttribute("replys",reply);
        model.addAttribute("PageInfo",PageInfo);
        return "/forum/post";
    }

    @RequestMapping("/addPost")
    @ResponseBody
    public Object addPost(HttpSession session,String postTitle,String postContent){
        Long postMaster = (Long) session.getAttribute("userId");
        forumModelService.addPost(postTitle,postContent,postMaster);
        return true;
    }

    @RequestMapping("/addReply")
    @ResponseBody
    public Object addReply(HttpSession session,Long postId,String replyContent){
        Long replyMaster = (Long) session.getAttribute("userId");
        forumModelService.addReply(postId,replyContent,replyMaster);
        return true;
    }

    @RequestMapping("/delPost")
    @ResponseBody
    public Object delPost(Long postId){
        forumModelService.delPost(postId);
        return true;
    }

    @RequestMapping("/delReply")
    @ResponseBody
    public Object delReply(Long replyId){
        forumModelService.delReply(replyId);
        return true;
    }
}
