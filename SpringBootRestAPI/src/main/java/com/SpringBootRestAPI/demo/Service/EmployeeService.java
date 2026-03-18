package com.SpringBootRestAPI.demo.Service;

import com.SpringBootRestAPI.demo.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getById(int id);
    EmployeeDTO updateEmployeeId(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
}
