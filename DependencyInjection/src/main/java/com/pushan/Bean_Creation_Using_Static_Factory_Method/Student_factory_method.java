package com.pushan.Bean_Creation_Using_Static_Factory_Method;

public class Student_factory_method {
    private Student_factory_method() {

    }

    public static Student_factory_method createStudentFactoryMethod() {
        return new Student_factory_method();
    }

    public void show() {
        System.out.println("Hello from static factory bean");
    }

}
