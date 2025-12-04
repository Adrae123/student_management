package com.projet.dao;

import com.projet.model.Course;
import java.util.List;

public interface CourseDao {
    void addCourse(Course c);
    List<Course> getAllCourses();
}
