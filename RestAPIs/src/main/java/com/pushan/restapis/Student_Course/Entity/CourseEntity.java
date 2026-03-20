package com.pushan.restapis.Student_Course.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String price;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
}
