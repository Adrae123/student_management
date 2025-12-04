package com.projet.dao;

import com.projet.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentDao implements StudentDao {

    @Override
    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getString("name"), rs.getString("email"));
                s.setId(rs.getInt("id"));
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void deleteStudent(int studentId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
