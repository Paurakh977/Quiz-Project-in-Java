package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Credentials {
    int RollNo;
    String Name;

    public Credentials(int rollNo, String name, String password) throws SQLException {
        RollNo = rollNo;
        Name = name;
        Password = password;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    String Password;


    Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db");



}
