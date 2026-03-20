package com.pushan.restapis.Student_Course.Service;

import com.pushan.restapis.Student_Course.DTO.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(int studentId, CourseDTO courseDTO);
    List<CourseDTO> getAllCourse();
    CourseDTO updateCourse(int id, CourseDTO courseDTO);
    void deleteCourse(int id);
}
