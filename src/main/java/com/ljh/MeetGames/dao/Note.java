package com.ljh.MeetGames.dao;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Note {
    private Long note_id;
    private Long game_id;
    private String note_content;
    private Long note_master;
    private Timestamp note_date;
    private String recommend;
    private String user_name;
    private String user_head;
}
