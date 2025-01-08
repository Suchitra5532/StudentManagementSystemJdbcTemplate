package com.durgesh.repository;



import com.durgesh.model.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);
    void update(Student student);
    void delete(int studentId);
    Student findById(int studentId);
    List<Student> findAll(int page, int size, String sortBy);
    // Custom queries
    List<Student> findStudentsByCourseId(int courseId);
    List<Student> findStudentsByDepartmentId(int departmentId);
    // Add more custom queries as needed
}
