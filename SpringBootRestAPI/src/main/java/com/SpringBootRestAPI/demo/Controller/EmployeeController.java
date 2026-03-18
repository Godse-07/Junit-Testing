package com.SpringBootRestAPI.demo.Controller;

import com.SpringBootRestAPI.demo.DTO.EmployeeDTO;
import com.SpringBootRestAPI.demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // create
    @PostMapping("/createEmployee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    // get all employee
    @GetMapping("/getEmployee")
    public List<EmployeeDTO> getEmployee() {
        return employeeService.getAllEmployee();
    }

    // get by id
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    // delete by id
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // update employee
    @PostMapping("/updateEmplyee/{id}")
    public EmployeeDTO updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeId(id, employeeDTO);
    }
}
