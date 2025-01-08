package com.durgesh.constant;

public class SqlConstantQuery {

    public static final String insertRecord = "INSERT INTO Students (first_name, last_name, email, date_of_birth, enrollment_date) VALUES (?, ?, ?, ?, ?)";

    public static final String updateQuery = "UPDATE Students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ?, enrollment_date = ? WHERE student_id = ?";
}
