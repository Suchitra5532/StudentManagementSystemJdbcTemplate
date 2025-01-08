package com.durgesh.repository.repositoryImpl;


import com.durgesh.constant.SqlConstantQuery;
import com.durgesh.model.Student;
import com.durgesh.repository.StudentRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Student student) {
//        String sql = "INSERT INTO Students (first_name, last_name, email, date_of_birth, enrollment_date) VALUES (?, ?, ?, ?, ?)";
       jdbcTemplate.update(SqlConstantQuery.insertRecord, student.getFirstName(), student.getLastName(), student.getEmail(), student.getDateOfBirth(), student.getEnrollmentDate());
    }

    @Override
    public void update(Student student) {
//        String sql = "UPDATE Students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ?, enrollment_date = ? WHERE student_id = ?";
        jdbcTemplate.update(SqlConstantQuery.updateQuery, student.getFirstName(), student.getLastName(), student.getEmail(), student.getDateOfBirth(), student.getEnrollmentDate(), student.getStudentId());
    }

    @Override
    public void delete(int studentId) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        jdbcTemplate.update(sql, studentId);
    }

    @Override
    public Student findById(int studentId) {
        String sql = "SELECT * FROM Students WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, (rs, rowNum) -> {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getDate("date_of_birth"));
            student.setEnrollmentDate(rs.getDate("enrollment_date"));
            student.setCreatedAt(rs.getTimestamp("created_at"));
            student.setUpdatedAt(rs.getTimestamp("updated_at"));
            return student;
        });
    }

    @Override
    public List<Student> findAll(int page, int size, String sortBy) {
        String sql = "SELECT * FROM Students ORDER BY " + sortBy + " LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[]{size, page * size}, (rs, rowNum) -> {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getDate("date_of_birth"));
            student.setEnrollmentDate(rs.getDate("enrollment_date"));
            student.setCreatedAt(rs.getTimestamp("created_at"));
            student.setUpdatedAt(rs.getTimestamp("updated_at"));
            return student;
        });
    }

    @Override
    public List<Student> findStudentsByCourseId(int courseId) {
        String sql = "SELECT s.* FROM Students s JOIN Fees f ON s.student_id = f.student_id WHERE f.course_id = ?";
        return jdbcTemplate.query(sql, new Object[]{courseId}, (rs, rowNum) -> {
            Student student
                    = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getDate("date_of_birth"));
            student.setEnrollmentDate(rs.getDate("enrollment_date"));
            student.setCreatedAt(rs.getTimestamp("created_at"));
            student.setUpdatedAt(rs.getTimestamp("updated_at"));
            return student;
        });
    }

    @Override
    public List<Student> findStudentsByDepartmentId(int departmentId) {
        String sql = "SELECT s.* FROM Students s JOIN Courses c ON s.student_id = c.course_id WHERE c.department_id = ?";
        return jdbcTemplate.query(sql, new Object[]{departmentId}, (rs, rowNum) -> {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getDate("date_of_birth"));
            student.setEnrollmentDate(rs.getDate("enrollment_date"));
            student.setCreatedAt(rs.getTimestamp("created_at"));
            student.setUpdatedAt(rs.getTimestamp("updated_at"));
            return student;
        });
    }
}
