package com.pushan.restapis.Student_Course.Service;

import com.pushan.restapis.Student_Course.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(int id);
    StudentDTO updateStudent(int id, StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    void deleteStudent(int id);
}
