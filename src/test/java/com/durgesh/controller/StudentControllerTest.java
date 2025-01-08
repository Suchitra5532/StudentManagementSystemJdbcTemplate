package com.durgesh.controller;


import com.durgesh.model.Student;
import com.durgesh.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");

        ResponseEntity<String> response = studentController.createStudent(student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student created successfully", response.getBody());
        verify(studentService, times(1)).save(student);
    }

    @Test
    void testUpdateStudent() {
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");

        ResponseEntity<String> response = studentController.updateStudent(1, student);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student updated successfully", response.getBody());
        verify(studentService, times(1)).update(student);
    }

    @Test
    void testDeleteStudent() {
        ResponseEntity<String> response = studentController.deleteStudent(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Student deleted successfully", response.getBody());
        verify(studentService, times(1)).delete(1);
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");

        when(studentService.findById(anyInt())).thenReturn(student);
        ResponseEntity<Student> response = studentController.getStudentById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
        verify(studentService, times(1)).findById(1);
    }

    @Test
    void testGetAllStudents() {
        when(studentService.findAll(anyInt(),anyInt(),anyString())).thenReturn(List.of(new Student()));
        ResponseEntity<List<Student>> response = studentController.getAllStudents(anyInt(),anyInt(),anyString());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
        verify(studentService, times(1)).findAll(anyInt(),anyInt(),anyString());
    }

    @Test
    void testGetStudentsByCourseId() {
        when(studentService.findStudentsByCourseId(anyInt())).thenReturn(List.of(new Student()));
        ResponseEntity<List<Student>> response = studentController.getStudentsByCourseId(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
        verify(studentService, times(1)).findStudentsByCourseId(1);
    }

    @Test
    void testGetStudentsByDepartmentId() {
        when(studentService.findStudentsByDepartmentId(anyInt())).thenReturn(List.of(new Student()));
        ResponseEntity<List<Student>> response = studentController.getStudentsByDepartmentId(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
        verify(studentService, times(1)).findStudentsByDepartmentId(1);
    }
}
