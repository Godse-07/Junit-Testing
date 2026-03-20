package com.pushan.restapis.Employee_address.Service;

import com.pushan.restapis.Employee_address.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int id);
}
