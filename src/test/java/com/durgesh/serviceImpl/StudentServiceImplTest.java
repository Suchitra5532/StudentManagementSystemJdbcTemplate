package com.durgesh.serviceImpl;

import com.durgesh.model.Student;
import com.durgesh.repository.StudentRepository;
import com.durgesh.service.serviceImpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Student student = new Student();
        studentService.save(student);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testUpdate() {
        Student student = new Student();
        student.setStudentId(1);
        studentService.update(student);
        verify(studentRepository, times(1)).update(student);
    }

    @Test
    void testDelete() {
        studentService.delete(1);
        verify(studentRepository, times(1)).delete(1);
    }

    @Test
    void testFindById() {
        when(studentRepository.findById(1)).thenReturn(new Student());
        Student student = studentService.findById(1);
        verify(studentRepository, times(1)).findById(1);
    }

    @Test
    void testFindAll() {
        when(studentRepository.findAll(anyInt(),anyInt(),anyString())).thenReturn(new ArrayList<>());
        List<Student> students = studentService.findAll(anyInt(),anyInt(),anyString());
        verify(studentRepository, times(1)).findAll(anyInt(),anyInt(),anyString());
    }
}
