package com.durgesh.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class Fee {
    private int feeId;
    private int studentId;
    private int courseId;
    private double amount;
    private Date dueDate;
    private String paymentStatus; // 'Paid', 'Pending', 'Overdue'
    private Date paymentDate;
    private Date createdAt;
    private Date updatedAt;
}
