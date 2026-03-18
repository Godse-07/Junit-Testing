package com.SpringBootRestAPI.demo.Service.Implementation;

import com.SpringBootRestAPI.demo.DTO.EmployeeDTO;
import com.SpringBootRestAPI.demo.Entity.EmployeeEntity;
import com.SpringBootRestAPI.demo.Mapper.Mapper;
import com.SpringBootRestAPI.demo.Respository.EmployeeRepository;
import com.SpringBootRestAPI.demo.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Mapper mapper;
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository, Mapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public void deleteEmployee(int id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDTO updateEmployeeId(int id, EmployeeDTO employeeDTO) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        mapper.map(employeeDTO, EmployeeEntity.class);

        EmployeeEntity savedEmp = employeeRepository.save(employee);

        return mapper.map(savedEmp, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO getById(int id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> (mapper.map(emp, EmployeeDTO.class)))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return mapper.map(savedEmployee, EmployeeDTO.class);
    }
}
