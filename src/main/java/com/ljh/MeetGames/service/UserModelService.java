package com.ljh.MeetGames.service;

import com.ljh.MeetGames.dao.User;
import com.ljh.MeetGames.mapper.UserModelMapper;
import com.ljh.MeetGames.utils.Md5;
import com.ljh.MeetGames.utils.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModelService {
    @Autowired
    UserModelMapper userModelMapper;

    Md5 md5;

    public User login(String loginName){
        User user = userModelMapper.login(loginName);
        return user;
    }

    public Boolean check(String loginName){
        User user = userModelMapper.login(loginName);
        if(user == null){
            return false;
        }
        return true;
    }

    public void register(String loginName,String password,String userName){
        String newPassword = md5.encrypt(password);
        Snowflake snowflake = new Snowflake(1, 1, 1);
        long userId = snowflake.nextId();
        userModelMapper.register(userId,loginName,newPassword);
        userModelMapper.addInfo(userId,userName);
    }

    public User userinfo(Long userId){
        User userInfo = userModelMapper.userInfo(userId);
        return userInfo;
    }

    public Boolean updateHeadImg(String headImg,Long userId){
        userModelMapper.updateHeadImg(headImg,userId);
        return true;
    }

    public Boolean changeInfo(User user){
        userModelMapper.changeInfo(user);
        return true;
    }
}
