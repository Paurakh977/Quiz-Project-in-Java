package org.example;

import models.Credentials;
import models.Questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    public static void login_user() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db");
        try (Scanner sc = new Scanner(System.in)) {
            String name, password;
            System.out.println("name");
            name = sc.nextLine();
            System.out.println("pass");
            password = sc.nextLine();

            if (Authentication.authenticateUser(connection, name, password)) {
                System.out.println("Id pass matched . logged in");
                Playroom p1 = new Playroom();
                p1.main(name);
            } else {
                System.out.println("Failed");
            }
        }
    }
}
