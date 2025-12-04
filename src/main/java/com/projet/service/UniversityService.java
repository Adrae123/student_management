package com.projet.service;

import com.projet.dao.JdbcStudentDao;
import com.projet.dao.JdbcCourseDao;
import com.projet.dao.JdbcEnrollmentDao;
import com.projet.model.Student;
import com.projet.model.Course;

import java.util.List;

public class UniversityService {

    private JdbcStudentDao studentDao = new JdbcStudentDao();
    private JdbcCourseDao courseDao = new JdbcCourseDao();
    private JdbcEnrollmentDao enrollmentDao = new JdbcEnrollmentDao();

    // Étudiants
    public void addStudent(Student s) {
        studentDao.addStudent(s);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    // Cours
    public void addCourse(Course c) {
        courseDao.addCourse(c);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    // Inscription
    public void enrollStudentToCourse(int studentId, int courseId) {
        enrollmentDao.enrollStudent(studentId, courseId);
    }

    public List<Course> getCoursesByStudent(int studentId) {
        return enrollmentDao.getCoursesByStudent(studentId);
    }
}
