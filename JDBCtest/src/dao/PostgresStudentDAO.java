package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresStudentDAO implements StudentDAO{

    private String URL = "jdbc:postgresql://localhost:5432/studentdb";
    private String USER = "postgres";
    private String PASSWORD = "root";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students WHERE id = ?";
        try(Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE students SET email = ? WHERE number = ?";
        try(Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getEmail());
            pstmt.setString(2, student.getNumber());
            pstmt.executeUpdate();
            System.out.println("Data updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudent() throws Exception {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try(Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAge(rs.getInt("age"));
                student.setNumber(rs.getString("number"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO students (name, email, age, number) VALUES (?, ?, ?, ?)";
        try(Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getNumber());
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
