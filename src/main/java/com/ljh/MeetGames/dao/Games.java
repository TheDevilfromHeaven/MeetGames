package com.ljh.MeetGames.dao;

import lombok.Data;

@Data
public class Games {
    private Long game_id;
    private String game_name;
    private String game_price;
    private String game_platform;
    private String introduction;
    private String game_img_mini;
    private String game_img1_src;
    private String game_img2_src;
    private String game_img3_src;
    private String game_img4_src;
    private String game_img_title;
}
