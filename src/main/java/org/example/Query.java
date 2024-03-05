package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import  java.sql.Connection;
public class Query {
    public static final String Users_table="Users";
    public static final String Credential_table="Credentials";


        public static void main(String[] args) throws SQLException {
            Connection connection=null;

            String url = "jdbc:sqlite:data.db";
            try {
                connection= DriverManager.getConnection(url);
                System.out.println("Connected to "+ url);
            } catch (SQLException e) {
                System.out.println("Failed");
                throw new RuntimeException(e);
            }
            String create_table_query="CREATE TABLE IF NOT EXISTS "+ Users_table + "(id  INTEGER PRIMARY KEY NOT NULL, RollNo INTEGER, Name TEXT, Grade Text, Section Text)";
            Statement st=connection.createStatement();
            String creat_table_credentails="CREATE TABLE IF NOT EXISTS "+ Credential_table + "(id  INTEGER PRIMARY KEY NOT NULL, RollNo INTEGER, Name TEXT, Password Text)";
            try {
                st.execute(create_table_query);
                st.execute(creat_table_credentails);
                System.out.println("User's table Created");
            } catch (SQLException e) {
                System.out.println("Failed to create table ");
                e.printStackTrace();
            }


        }
    }


