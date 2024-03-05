package org.example;

import models.Users;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

public class Authentication {


    public static boolean authenticateUser(Connection connection, String username, String password) throws SQLException {
        String selectQuery = "SELECT * FROM Credentials WHERE Name = ? AND Password = ?";

        try (PreparedStatement authQuery = connection.prepareStatement(selectQuery)) {
            String hasedpassword= Users.hashPassword(password);
            authQuery.setString(1, username);
            authQuery.setString(2, hasedpassword);
            try (ResultSet rs = authQuery.executeQuery()) {
                return rs.next();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        // Return false if an exception occurs or no records found
    }
}
