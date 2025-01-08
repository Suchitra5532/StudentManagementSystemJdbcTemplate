package com.durgesh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Department {
    private int departmentId;
    private String departmentName;
    private Date createdAt;
    private Date updatedAt;
}
