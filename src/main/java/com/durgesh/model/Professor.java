package com.durgesh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Professor {
    private int professorId;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private Date createdAt;
    private Date updatedAt;
}
