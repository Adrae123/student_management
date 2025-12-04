package com.projet.dao;

import com.projet.model.Student;
/*import java.sql.*;*/
import java.util.List;


public interface StudentDao { // renommer StudentDAO -> StudentDao
    void addStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(int studentId);
}
