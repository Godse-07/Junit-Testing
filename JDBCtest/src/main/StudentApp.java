package main;

import dao.PostgresStudentDAO;
import dao.StudentDAO;
import exception.InvalidStudentDataException;

import java.util.Scanner;

public class StudentApp {
    static void validateStudentData(String name, String email, int age, String number) throws Exception {
        if(name == null || name.isEmpty()) {
            throw new Exception("Name cannot be empty");
        }
        if(email == null || email.isEmpty()) {
            throw new Exception("Email cannot be empty");
        }
        if(age < 0) {
            throw new Exception("Age cannot be negative");
        }
        if(number == null || number.isEmpty()) {
            throw new Exception("Number cannot be empty");
        }
        if(number.length() != 10) {
            throw new Exception("Number must be 10 digits");
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(!email.matches(emailRegex)) {
            throw new Exception("Invalid email format");
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO sdao = new PostgresStudentDAO();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter number: ");
                        String number = sc.nextLine();
                        validateStudentData(name, email, age, number);
                        sdao.addStudent(new model.Student(0, name, email, age, number));
                        break;
                    case 2:
                        sdao.getAllStudent().forEach(student -> {
                            System.out.println(student.getId() + " " + student.getName() + " " + student.getEmail() + " " + student.getAge() + " " + student.getNumber());
                        });
                        break;
                    case 3:
                        System.out.print("Enter number of the student to update: ");
                        String updateNumber = sc.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        validateStudentData("dummy", newEmail, 0, updateNumber);
                        sdao.updateStudent(new model.Student(0, null, newEmail, 0, updateNumber));
                        break;
                    case 4:
                        System.out.print("Enter id of the student to delete: ");
                        int deleteId = sc.nextInt();
                        sdao.deleteStudent(deleteId);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InvalidStudentDataException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
