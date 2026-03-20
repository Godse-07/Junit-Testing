package com.pushan.restapis.Student_Course.DTO;

import lombok.Data;

@Data
public class CourseDTO {
    private int id;
    private String title;
    private String price;
    private int studentId;
}
