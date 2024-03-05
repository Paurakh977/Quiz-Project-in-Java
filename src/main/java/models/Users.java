package models;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;

public class Users  extends Credentials{
    public static final String user_table="Users";
    public static final String credential_table="Credentials";
    public static final String roll_column="RollNo";
    public static final String name_column="Name";
    public static final String grade_column="Grade";
    public static final String section_column="Section";
    int RollNo;
    String Name, Grade, Section,Password;

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public void setPassword(String password) {
        Password = password;
    }

    public Users(int rollNo, String name, String grade, String section,String Password) throws SQLException {
        super(rollNo,name,Password);
        this.RollNo = rollNo;
        this.Name = name;
        this.Grade = grade;
        this.Section = section;
        this.Password=Password;
        
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


    public void insert_users() throws SQLException {
        String select_query="SELECT * FROM "+user_table+" WHERE "+roll_column+" = ? OR "+name_column+ "= ?";
        String insertQuery_users = "INSERT INTO "+user_table+" (RollNo, Name, Grade, Section) VALUES (?, ?, ?, ?)";
        String insertQuery_credentials = "INSERT INTO "+credential_table+" (RollNo, Name, Password) VALUES (?, ?, ?)";
        try(PreparedStatement selectstatement= connection.prepareStatement(select_query);
            PreparedStatement insertuserstatement= connection.prepareStatement(insertQuery_users);
            PreparedStatement insertcredentails= connection.prepareStatement(insertQuery_credentials))
        {
            selectstatement.setInt(1,this.getRollNo());
            selectstatement.setString(2,this.getName());
            try(ResultSet rs=selectstatement.executeQuery()){
                if (rs.next()){
                    System.out.println("User already exists with RollNo " + this.getRollNo() + " or Name " + this.getName());
                    return;
                }
            }
            try{
                String hashedpswrd=hashPassword(this.getPassword());
                insertcredentails.setInt(1, this.getRollNo());
                insertcredentails.setString(2, this.getName());
                insertcredentails.setString(3, hashedpswrd);
                insertcredentails.executeUpdate();
                System.out.println("Credentials regestered of user: "+ this.getName() );
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            try{
                insertuserstatement.setInt(1, this.getRollNo());
                insertuserstatement.setString(2, this.getName());
                insertuserstatement.setString(3, this.getGrade());
                insertuserstatement.setString(4, this.getSection());
                insertuserstatement.executeUpdate();
                System.out.println("Welcome "+this.getName());
            }catch (Exception e){
                e.printStackTrace();
            }

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
            Users u1=new Users(rollno,name,grade,section,null);
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
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = messageDigest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}

