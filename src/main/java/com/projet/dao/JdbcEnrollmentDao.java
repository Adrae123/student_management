package com.projet.dao;

import com.projet.model.Course;
import com.projet.model.Enrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEnrollmentDao implements EnrollmentDao {

    @Override
    public void enrollStudent(int studentId, int courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            stmt.executeUpdate();
            System.out.println("Étudiant inscrit au cours !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getCoursesByStudent(int studentId) {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT c.id, c.title FROM courses c " +
                         "JOIN enrollment e ON c.id = e.course_id " +
                         "WHERE e.student_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setTitle(rs.getString("title"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
