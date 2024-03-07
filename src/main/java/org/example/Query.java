package org.example;

import java.sql.*;

public class Query {
    public static final String Users_table = "Users";
    public static final String Credential_table = "Credentials";
    public static final String Score_table = "Scores";
    public static final String url = "jdbc:sqlite:data.db";
    public static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void show_taable() throws SQLException {
        String select_query = "SELECT * FROM " + Score_table + " WHERE id  < 5 ";
        try (PreparedStatement selectstatement = connection.prepareStatement(select_query)) {
            ResultSet rs = selectstatement.executeQuery();
            System.out.println("Top Scores");
            System.out.print("Username\t\t");
            System.out.println("Score %");
            while (rs.next()) {
                System.out.print(rs.getString("Name") + "\t\t");
                System.out.println(rs.getInt("Score"));
            }
        }
    }

    public static void score(String name, double score) throws SQLException {
        String insert_score = "INSERT INTO Scores (name, score) VALUES (?, ?)";
        PreparedStatement insertscorestatement = connection.prepareStatement(insert_score);
        insertscorestatement.setString(1, name);
        insertscorestatement.setDouble(2, score);
        insertscorestatement.executeUpdate();
        show_taable();
    }

    public static void main(String[] args) throws SQLException {
        String create_table_query = "CREATE TABLE IF NOT EXISTS " + Users_table
                + "(id  INTEGER PRIMARY KEY NOT NULL, RollNo INTEGER, Name TEXT, Grade Text, Section Text)";
        Statement st = connection.createStatement();
        String creat_table_credentails = "CREATE TABLE IF NOT EXISTS " + Credential_table
                + "(id  INTEGER PRIMARY KEY NOT NULL, RollNo INTEGER, Name TEXT, Password Text)";
        try {
            st.execute(create_table_query);
            st.execute(creat_table_credentails);
            System.out.println("User's table Created");
        } catch (SQLException e) {
            System.out.println("Failed to create table ");
            e.printStackTrace();
        }

        String crete_score_table = "CREATE TABLE IF NOT EXISTS " + Score_table
                + " (id INTEGER PRIMARY KEY NOT NULL , Name TEXT, Score INTEGER)";
        Statement score_statement = connection.createStatement();
        try {
            score_statement.execute(crete_score_table);
            System.out.println("Score table created");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
