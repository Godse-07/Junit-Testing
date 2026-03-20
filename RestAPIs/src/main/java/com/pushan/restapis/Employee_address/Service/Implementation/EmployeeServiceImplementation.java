package com.pushan.restapis.Employee_address.Service.Implementation;

import com.pushan.restapis.Employee_address.DTO.AddressDTO;
import com.pushan.restapis.Employee_address.DTO.EmployeeDTO;
import com.pushan.restapis.Employee_address.Entity.AddressEntity;
import com.pushan.restapis.Employee_address.Entity.EmployeeEntity;
import com.pushan.restapis.Employee_address.Mapper.Mapper;
import com.pushan.restapis.Employee_address.Repository.EmployeeRepository;
import com.pushan.restapis.Employee_address.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Mapper mapper;


    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        System.out.println("Employee with ID " + id + " has been deleted.");
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {

        EmployeeEntity existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));

        if (employeeDTO.getName() != null) {
            existing.setName(employeeDTO.getName());
        }

        if (employeeDTO.getEmail() != null) {
            existing.setEmail(employeeDTO.getEmail());
        }

        if (employeeDTO.getMobile() != null) {
            existing.setMobile(employeeDTO.getMobile());
        }

        if (employeeDTO.getGender() != null) {
            existing.setGender(employeeDTO.getGender());
        }

        if (employeeDTO.getDesignation() != null) {
            existing.setDesignation(employeeDTO.getDesignation());
        }

        if (employeeDTO.getSalary() != 0) {
            existing.setSalary(employeeDTO.getSalary());
        }

        if (employeeDTO.getDateOfJoining() != null) {
            existing.setDateOfJoining(employeeDTO.getDateOfJoining());
        }

        if (employeeDTO.getAddress() != null) {
            if (existing.getAddress() == null) {
                existing.setAddress(mapper.map(employeeDTO.getAddress(), AddressEntity.class));
            } else {
                AddressEntity address = existing.getAddress();
                AddressDTO dto = employeeDTO.getAddress();

                if (dto.getStreet() != null) address.setStreet(dto.getStreet());
                if (dto.getCity() != null) address.setCity(dto.getCity());
                if (dto.getState() != null) address.setState(dto.getState());
                if (dto.getCountry() != null) address.setCountry(dto.getCountry());
                if (dto.getPincode() != null) address.setPincode(dto.getPincode());
            }
        }

        EmployeeEntity updated = employeeRepository.save(existing);

        return mapper.map(updated, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity, EmployeeDTO.class))
                .toList();
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO, EmployeeEntity.class);
        return mapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
