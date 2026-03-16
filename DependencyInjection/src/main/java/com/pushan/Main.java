package com.pushan;

import com.pushan.Bean_Creation_Using_Constructor_Injection.Student_Constructor;
import com.pushan.Bean_Creation_Using_Default_Constructor.Student;
import com.pushan.Bean_Creation_Using_Setter_Injection.Student_setter;
import com.pushan.Bean_Creation_Using_Static_Factory_Method.Student_factory_method;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ApplicationContext context1 = new ClassPathXmlApplicationContext("Bean_Creation_Using_Default_Constructor/applicationContext.xml");
        Student sBean =(Student) context1.getBean("student");
        sBean.show();

        System.out.println("--------Two----------");

        ApplicationContext context2 = new ClassPathXmlApplicationContext("Bean_Creation_Using_Setter_Injection/applicationContext.xml");
        Student_setter sSetterBean = (Student_setter) context2.getBean("student_setter");
        sSetterBean.displayInfo();

        // -- Three
        System.out.println("--------Three----------");

        ApplicationContext context3 = new ClassPathXmlApplicationContext("Bean_Creation_Using_Constructor_Injection/applicationContext.xml");
        Student_Constructor sConstructorBean = (Student_Constructor) context3.getBean("student_constructor");
        sConstructorBean.show();

        // -- Four
        System.out.println("--------Four----------");

        ApplicationContext contest4 = new ClassPathXmlApplicationContext("Bean_Creation_Using_Static_Factory_Method/applicationContext.xml");
        Student_factory_method sFactoryMethodBean = (Student_factory_method) contest4.getBean("Student_factory_method");
        sFactoryMethodBean.show();
    }
}
