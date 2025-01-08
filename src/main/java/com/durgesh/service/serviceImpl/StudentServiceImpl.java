package com.durgesh.service.serviceImpl;


import com.durgesh.model.Student;
import com.durgesh.repository.StudentRepository;
import com.durgesh.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> findAll(int page, int size, String sortBy) {
        return studentRepository.findAll(page, size, sortBy);
    }

    @Override
    public List<Student> findStudentsByCourseId(int courseId) {
        return studentRepository.findStudentsByCourseId(courseId);
    }

    @Override
    public List<Student> findStudentsByDepartmentId(int departmentId) {
        return studentRepository.findStudentsByDepartmentId(departmentId);
    }
}