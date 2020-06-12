package com.ljh.MeetGames.dao;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reply {
    private Long reply_id;
    private Long post_id;
    private String reply_content;
    private Long reply_master;
    private Timestamp reply_date;
    private String user_name;
    private String user_head;
}
