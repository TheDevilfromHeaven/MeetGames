package com.ljh.MeetGames.dao;

import lombok.Data;

@Data
public class User {
    private Long user_id;
    private String login_name;
    private String password;
    private String user_name;
    private String sex;
    private String birthday;
    private String email;
    private String autograph;
    private String user_head;
    private String state;
}
