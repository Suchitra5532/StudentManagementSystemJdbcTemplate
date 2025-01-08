package com.durgesh.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Student {
    private int studentId;
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;
    private Date dateOfBirth;
    private Date enrollmentDate;
    private Date createdAt;
    private Date updatedAt;
}
