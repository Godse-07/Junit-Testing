package com.pushan.Bean_Creation_Using_Constructor_Injection;

public class Student_Constructor {
    private String name;
    public Student_Constructor(String name) {
        this.name = name;
    }
    public void show() {
        System.out.println("Student Name from student constructor: " + name);
    }
}
