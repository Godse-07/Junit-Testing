package com.pushan.restapis.Student_Course.Controller;

import com.pushan.restapis.Student_Course.DTO.CourseDTO;
import com.pushan.restapis.Student_Course.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/createCourse/{id}")
    public CourseDTO createCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(id, courseDTO);
    }

    @GetMapping("/getAllCourse")
    public List<CourseDTO> courseDTOList() {
        return courseService.getAllCourse();
    }

    @PutMapping("/updateCourse/{id}")
    public CourseDTO updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(id, courseDTO);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
