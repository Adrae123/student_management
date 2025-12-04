package com.projet.dao;

import com.projet.model.Course;
import java.util.List;

public interface EnrollmentDao {
    void enrollStudent(int studentId, int courseId);
    List<Course> getCoursesByStudent(int studentId);
}
