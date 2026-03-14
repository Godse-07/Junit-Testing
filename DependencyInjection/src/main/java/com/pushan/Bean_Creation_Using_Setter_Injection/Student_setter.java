package com.pushan.Bean_Creation_Using_Setter_Injection;

public class Student_setter {
    private String name;
    public Student_setter() {
        System.out.println("Student setter bean creation setter injection");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
    }
}
