package org.example;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException {
        System.out.println("Login or Signup?");
        System.out.println("Press l to login and s to signup");
        try (Scanner sc = new Scanner(System.in)) {
            String descision = sc.nextLine();
            if (descision.equalsIgnoreCase("l")) {
                Login.login_user();
            } else if (descision.equalsIgnoreCase("s")) {
                Signup.regesiter_user();
            } else {
                System.out.println("Invalid input given " + descision);
            }
        }
    }

}
