package com.JPA.employee_address_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "employee",
        uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String employeeName;

    @Email
    @Column(unique = true)
    private String email;

    private String gender;

    private String password;

    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    @Positive(message = "Salary must be greater than 0")
    private double salary;

    private LocalDate dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}