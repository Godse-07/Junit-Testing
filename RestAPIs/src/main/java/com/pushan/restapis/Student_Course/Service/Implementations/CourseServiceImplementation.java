package com.pushan.restapis.Student_Course.Service.Implementations;

import com.pushan.restapis.Student_Course.DTO.CourseDTO;
import com.pushan.restapis.Student_Course.Entity.CourseEntity;
import com.pushan.restapis.Student_Course.Entity.StudentEntity;
import com.pushan.restapis.Student_Course.Mapper.Mapper;
import com.pushan.restapis.Student_Course.Repository.CourseRepository;
import com.pushan.restapis.Student_Course.Repository.StudentRepository;
import com.pushan.restapis.Student_Course.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public CourseDTO createCourse(int studentId, CourseDTO courseDTO) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        CourseEntity course = mapper.map(courseDTO, CourseEntity.class);
        course.setStudent(student);
        CourseEntity saved = courseRepository.save(course);
        return mapper.map(saved, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<CourseEntity> courseEntityList = courseRepository.findAll();
        return courseEntityList.stream()
                .map(courseEntity -> mapper.map(courseEntity, CourseDTO.class))
                .toList();
    }

    @Override
    public CourseDTO updateCourse(int id, CourseDTO courseDTO) {
        CourseEntity existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        existing.setPrice(courseDTO.getPrice());
        existing.setTitle(courseDTO.getTitle());
        CourseEntity saved = courseRepository.save(existing);
        return mapper.map(saved, CourseDTO.class);
    }

    @Override
    public void deleteCourse(int id) {
        CourseEntity course = courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found with id: "+ id)
        );
        courseRepository.delete(course);
        System.out.println("Course deleted");
        System.out.println("And deleted course is -> " + course.toString());
    }
}
