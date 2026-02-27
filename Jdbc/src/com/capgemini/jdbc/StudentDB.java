package com.capgemini.jdbc;

import java.sql.*;
import java.util.Scanner;

public class StudentDB {
    static final String URL = "jdbc:postgresql://localhost:5432/students";
    static final String USER = "postgres";
    static final String PASSWORD = "root";


    static void main(String[] args) throws ClassNotFoundException {
        try {
            // this is the step where we load and register the driver
            Class.forName("org.postgresql.Driver");

            // Build the connection URL using static and final variables for better maintainability
            // Establish the connection
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully!");

                createTable(conn);

                insertDynamicSafe(conn);

                fetchData(conn);

                updateData(conn);

                deleteData(conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // create table
    public static void createTable(Connection conn) throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Table 'students' created successfully!");
    }

    // insert using Statement
    public static void insertUsingStatement(Connection conn) throws SQLException {
        String sql = "INSERT INTO students (name, email) VALUES ('Pushan', '"
                + "Pushan@gmail.com" + "')";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Data inserted using Statement!");
    }

    // insert using PreparedStatement
    public static void insertUsingPreparedStatement(Connection conn) throws SQLException {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "Godse");
        pstmt.setString(2, "Godse@gmail.com");
        pstmt.execute();
        System.out.println("Data inserted using PreparedStatement!");
    }

    // insert dynamic data
    public static void insertDynamicSafe(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many recors do you want to insert?");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++) {
            System.out.println("Enter Name ");
            String name = sc.nextLine();
            System.out.println("Enter Email ");
            String email = sc.nextLine();
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Record " + (i+1) + " inserted successfully!");
        }
    }

    // fetch data
    public static void fetchData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
        }
    }

    // delete data
    public static void deleteData(Connection conn) throws SQLException {
        System.out.println("Enter the id of the user to delete ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String sql = "DELETE FROM students WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Record with id " + id + " deleted successfully!");
        } else {
            System.out.println("No record found with id " + id);
        }
    }

    // update data
    public static void updateData(Connection conn) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the user to update ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new name ");
        String name = sc.nextLine();
        System.out.println("Enter the new email ");
        String email = sc.nextLine();
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setInt(3, id);
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Record with id " + id + " updated successfully!");
        } else {
            System.out.println("No record found with id " + id);
        }
    }

}
