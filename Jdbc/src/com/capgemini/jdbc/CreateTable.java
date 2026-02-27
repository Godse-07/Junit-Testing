package com.capgemini.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CreateTable {

    static final String URL = "jdbc:postgresql://localhost:5432/testdb";
    static final String USER = "postgres";
    static final String PASSWORD = "root";

    static void main(String[] args) throws ClassNotFoundException {
        try {
            // 1. Load and register the driver
            Class.forName("org.postgresql.Driver");

            // 2. Build the connection URL
            // using static and final variables for better maintainability

            // 3. Establish the connection
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully!");
//                createTable(conn);
//                insertUsingStatement(conn);
//                insertUsingPreparedStatement(conn);
//                insertDynamicUnsafe(conn);
                insertDynamicSafe(conn);
                fetchData(conn);
            } catch (Exception e) {
                System.out.println("Connection failed: " + e.getMessage());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 1 Create Table
    public static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";

        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Table 'users' created successfully!");
    }

    // 2 Insert using Statement
    public static void insertUsingStatement(Connection conn) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES ('Pushan', 'Pushan@gmail.com')";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Data inserted using Statement!");
    }

    // 3. PreparedStatement (Hardcoded)
    public static void insertUsingPreparedStatement(Connection conn) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "Godse");
        pstmt.setString(2, "Godse@gmail.com");
        pstmt.executeUpdate();
        System.out.println("Data inserted using PreparedStatement!");
    }

    // 4. Dynamic Insert (Unsafe)
    public static void insertDynamicUnsafe(Connection conn) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name (Unsafe Insert): ");
        String name = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO users(name,email) VALUES('" + name + "','" + email + "')";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

        System.out.println("Inserted (Unsafe)");
    }

    // 5. Dynamic Insert (Safe)
    public static void insertDynamicSafe(Connection conn) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name (Safe Insert): ");
        String name = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        String sql = "INSERT INTO users(name,email) VALUES(?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, email);

        pstmt.executeUpdate();

        System.out.println("Inserted (Safe)");
    }

    // 6. Fetch Data
    public static void fetchData(Connection conn) throws SQLException {

        String sql = "SELECT * FROM users";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nUsers Table Data:");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("email")
            );
        }
    }

}

