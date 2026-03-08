package com.JPA.employee_address_app.service;

import com.JPA.employee_address_app.entity.Employee;
import com.JPA.employee_address_app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // insert employee
    public Employee saveEmployee(Employee emp) {
        return repository.save(emp);
    }

    // update employee
    public Employee updateEmployee(long id, Employee newData) {
        Employee emp = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setEmployeeName(newData.getEmployeeName());
        emp.setSalary(newData.getSalary());
        emp.setPhone(newData.getPhone());
        System.out.println("Employee updated successfully");
        return repository.save(emp);
    }

    // delete employee
    public void deleteEmployee(long id) {
        repository.deleteById(id);
        System.out.println("Employee deleted successfully");
    }

    // Fetch employee by id
    public Employee getEmployeeById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Employee not found");
                });
    }

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

}
