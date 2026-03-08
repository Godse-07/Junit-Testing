package dao;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class DummyStudentDAO implements StudentDAO{

    List<Student> list = new ArrayList<>();

    @Override
    public void addStudent(Student student) throws Exception {
        list.add(student);
        System.out.println("Data added successfully in Dummy DAO");
    }

    @Override
    public List<Student> getAllStudent() throws Exception {
        return list;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        System.out.println("Dummy, update");
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        System.out.println("Dummy, delete");
    }
}
