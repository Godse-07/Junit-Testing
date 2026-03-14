package com.pushan.service;

import com.pushan.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void addEmployee() {
        System.out.println("Employee Added");
        employee.displayEmployee();
    }

    public void updateEmployee() {
        System.out.println("Employee Updated");
    }

    public void deleteEmployee() {
        System.out.println("Employee Deleted");
    }

    public void getEmployee() {
        System.out.println("Employee Details:");
        employee.displayEmployee();
    }

}
