package org.example;

import models.Users;

import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
    public static  void regesiter_user() throws SQLException {
        Scanner sc=new Scanner(System.in);
        String name,grade,section,pass;
        int rollno;
        System.out.println("Enter your Username");
        name=sc.nextLine();
        System.out.println("Enter your password");
        pass= sc.nextLine();
        System.out.println("Your Grade");
        grade= sc.nextLine();
        System.out.println("Section");
        section= sc.nextLine();
        System.out.println("Roll no:");
        try{
            rollno= sc.nextInt();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Roll number expected integer.Please try again");
            return;
        }
        try{
            Users u1=new Users(rollno,name,grade,section,pass);
            try{
                u1.insert_users();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
