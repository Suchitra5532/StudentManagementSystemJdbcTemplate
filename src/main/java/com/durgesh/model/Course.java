package com.durgesh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Course {
    private int courseId;
    private String courseName;
    private String courseCode;
    private int credits;
    private int professorId;
    private int departmentId;
    private Date createdAt;
    private Date updatedAt;
}
