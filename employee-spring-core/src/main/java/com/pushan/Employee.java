package com.pushan;

public class Employee {

    private int employeeId;
    private String employeeName;
    private double salary;
    private Department department;

    // Setter Injection

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Salary: " + salary);
        System.out.println("Department ID: " + department.getDepartmentId());
        System.out.println("Department Name: " + department.getDepartmentName());
    }
}