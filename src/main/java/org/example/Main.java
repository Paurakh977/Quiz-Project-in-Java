package org.example;


import models.Users;

import java.sql.SQLException;

public class Main {
    public static final String Users_table="Users";
    public static void main(String[] args) throws SQLException {
        Users paurakh=new Users(2405,"wbcu Raiwehidj ","XII","Lobuche");
        paurakh.insert_users();
        Users jpt=new Users(7,"abc","XI","Changdcla");
        jpt.insert_users();
        jpt.display();
        int value=10;
        jpt.name_wala(value);

    }
}
