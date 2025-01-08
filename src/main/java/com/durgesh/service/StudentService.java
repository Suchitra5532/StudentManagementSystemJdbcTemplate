package com.durgesh.service;

import com.durgesh.model.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    void update(Student student);
    void delete(int studentId);
    Student findById(int studentId);
    List<Student> findAll(int page, int size, String sortBy);
    List<Student> findStudentsByCourseId(int courseId);
    List<Student> findStudentsByDepartmentId(int departmentId);
}
