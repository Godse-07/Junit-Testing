package com.pushan.restapis.Student_Course.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<CourseEntity> courses;
}
