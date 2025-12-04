package com.projet.dao;

import com.projet.model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCourseDao implements CourseDao {

    @Override
    public void addCourse(Course course) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO courses (title) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.getTitle());
            stmt.executeUpdate();
            System.out.println("Cours ajouté !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM courses";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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
