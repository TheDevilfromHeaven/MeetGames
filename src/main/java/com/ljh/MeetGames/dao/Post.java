package com.ljh.MeetGames.dao;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Post {
    private Long post_id;
    private String post_title;
    private String post_content;
    private Timestamp post_date;
    private Long post_master;
    private String user_name;
    private String user_head;
}
