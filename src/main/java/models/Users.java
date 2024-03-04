package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Users {
    public static final String user_table="Users";
    public static final String roll_column="RollNo";
    public static final String name_column="Name";
    public static final String grade_column="Grade";
    public static final String section_column="Section";
    int RollNo;
    String Name, Grade, Section;

    public Users(int rollNo, String name, String grade, String section) throws SQLException {
        RollNo = rollNo;
        Name = name;
        Grade = grade;
        Section = section;
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

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db");


    public void insert_users(){
        String insertQuery = "INSERT INTO "+user_table+" (RollNo, Name, Grade, Section) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)){
            preparedStatement.setInt(1, this.getRollNo());
            preparedStatement.setString(2, this.getName());
            preparedStatement.setString(3, this.getGrade());
            preparedStatement.setString(4, this.getSection());
            preparedStatement.executeUpdate();
            System.out.println("User "+ this.getName()+" Regestred into table");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void display(){
        String select_query="Select * FROM "+user_table;
        List <Users> userslist=new ArrayList<>();
        try (PreparedStatement preparedStatement= connection.prepareStatement(select_query)){
        ResultSet rs=preparedStatement.executeQuery();
            System.out.println("rs is --->"+rs);
        while (rs.next()){
            int rollno=rs.getInt(roll_column);
            String name=rs.getString(name_column);
            String grade=rs.getString(grade_column);
            String section=rs.getString(section_column);
            Users u1=new Users(rollno,name,grade,section);
            userslist.add(u1);
        }
            System.out.println("list is --->"+userslist);
        for(Users u:userslist){
            System.out.println("Name is : "+u.getName()+" rol "+u.getRollNo() );
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void name_wala(int value){
        String select_query="SELECT * FROM "+user_table+" WHERE "+roll_column+" < ?";
        try (PreparedStatement preparedStatement= connection.prepareStatement(select_query)){
            preparedStatement.setInt(1,value);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String name=rs.getString(name_column);
                int roll=rs.getInt(roll_column);
                System.out.println("name: "+name+" roll: "+roll);
            }
            System.out.println(value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

