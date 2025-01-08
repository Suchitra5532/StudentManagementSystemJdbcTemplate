package com.durgesh.repositoryImpl;

import com.durgesh.model.Student;
import com.durgesh.repository.repositoryImpl.StudentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class StudentRepositoryImplTest {

    @InjectMocks
    private StudentRepositoryImpl studentRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setDateOfBirth(Date.valueOf("2000-01-01"));
        student.setEnrollmentDate(Date.valueOf("2020-09-01"));

        studentRepository.save(student);
        verify(jdbcTemplate, times(1)).update(any(String.class), any(), any(), any(), any());
    }

    @Test
    void testUpdate() {
        Student student = new Student();
        student.setStudentId(1);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setDateOfBirth(Date.valueOf("2000-01-01"));
        student.setEnrollmentDate(Date.valueOf("2020-09-01"));

        studentRepository.update(student);
        verify(jdbcTemplate, times(1)).update(any(String.class), any(), any(), any(), any(), anyInt());
    }

    @Test
    void testDelete() {
        studentRepository.delete(1);
        verify(jdbcTemplate, times(1)).update(any(String.class), anyInt());
    }

  /* // @Test
    void testFindById() {
        when(jdbcTemplate.queryForObject(any(String.class), any(Object[].class), any())).thenReturn(new Student());

        Student student = studentRepository.findById(1);
        assertNotNull(student);
        verify(jdbcTemplate, times(1)).queryForObject(any(String.class), any(Object[].class), any());
    }

  //  @Test
    void testFindAll() {
        when(jdbcTemplate.query(any(String.class), any())).thenReturn(List.of(new Student()));

        List<Student> students = studentRepository.findAll(anyInt(),anyInt(),anyString());
        assertFalse(students.isEmpty());
        verify(jdbcTemplate, times(1)).query(any(String.class), any());
    }*/
}
