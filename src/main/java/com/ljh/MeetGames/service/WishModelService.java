package com.ljh.MeetGames.service;

import com.ljh.MeetGames.dao.Wish;
import com.ljh.MeetGames.mapper.WishModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishModelService {
    @Autowired
    WishModelMapper wishModelMapper;

    public Boolean exist(Long userId,Long gameId){
        Wish exist = wishModelMapper.exist(userId, gameId);
        if (exist != null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean addWish(Long userId,Long gameId){
        wishModelMapper.addWish(userId,gameId);
        return true;
    }

    public List<Wish> wishList(Long userId){
        List<Wish> wishList = wishModelMapper.wishList(userId);
        return wishList;
    }

    public Boolean removeWish(Long userId,Long gameId){
        wishModelMapper.removeWish(userId, gameId);
        return true;
    }
}
