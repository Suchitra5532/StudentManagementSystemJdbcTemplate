package com.durgesh.controller;

import com.durgesh.model.Student;
import com.durgesh.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.ok("Student created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setStudentId(id);
        studentService.update(student);
        return ResponseEntity.ok("Student updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("v1/{page}/{size}/{sortBy}")
    public ResponseEntity<List<Student>> getAllStudents(int page, int size, String sortBy) {
        return ResponseEntity.ok(studentService.findAll(page, size, sortBy));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable int courseId)
    {
        return ResponseEntity.ok(studentService.findStudentsByCourseId(courseId));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Student>> getStudentsByDepartmentId(@PathVariable int departmentId) {
        return ResponseEntity.ok(studentService.findStudentsByDepartmentId(departmentId));
    }
}
