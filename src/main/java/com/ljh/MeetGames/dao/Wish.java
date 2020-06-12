package com.ljh.MeetGames.dao;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Wish {
    private Long user_id;
    private Long game_id;
    private Timestamp create_date;
    private String game_name;
    private String game_img_mini;
}
