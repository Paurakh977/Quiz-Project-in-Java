package org.example;


import models.Users;

import javax.sound.midi.Soundbank;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        System.out.println("Login or Signup?");
        System.out.println("Press l to login and s to signup");
        Scanner sc=new Scanner(System.in);
        String descision= sc.nextLine();
        if (descision.equalsIgnoreCase("l")){
            Login.login_user();
        } else if (descision.equalsIgnoreCase("s")) {
            Signup.regesiter_user();
        }
        else {
            System.out.println("Invalid input given "+descision);
        }
    }



}
