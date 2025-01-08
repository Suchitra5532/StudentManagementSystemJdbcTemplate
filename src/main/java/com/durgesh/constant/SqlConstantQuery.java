package com.durgesh.constant;

public class SqlConstantQuery {

    public static final String INSERTRECORD = "INSERT INTO Students (first_name, last_name, email, date_of_birth, enrollment_date) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATERECORD = "UPDATE Students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ?, enrollment_date = ? WHERE student_id = ?";
    public static final String DELETE = "DELETE FROM Students WHERE student_id = ?";
}
