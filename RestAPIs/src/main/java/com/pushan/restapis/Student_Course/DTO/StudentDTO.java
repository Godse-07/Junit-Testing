package com.pushan.restapis.Student_Course.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private int id;
    private String name;
    private String email;
    private List<CourseDTO> courses;
}
