package com.pushan.restapis.Student_Course.Service.Implementations;

import com.pushan.restapis.Student_Course.DTO.StudentDTO;
import com.pushan.restapis.Student_Course.Entity.CourseEntity;
import com.pushan.restapis.Student_Course.Entity.StudentEntity;
import com.pushan.restapis.Student_Course.Mapper.Mapper;
import com.pushan.restapis.Student_Course.Repository.StudentRepository;
import com.pushan.restapis.Student_Course.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentEntity student = mapper.map(studentDTO, StudentEntity.class);
        if(student.getCourses() != null) {
            for(CourseEntity course: student.getCourses()) {
                course.setStudent(student);
            }
        }
        StudentEntity saved = studentRepository.save(student);
        return mapper.map(saved, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return mapper.map(studentRepository.findById(id).orElseThrow(), StudentDTO.class);
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        StudentEntity student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        if(studentDTO.getCourses() != null) {
            for(CourseEntity course: student.getCourses()) {
                course.setStudent(student);
            }
        }
        return mapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
