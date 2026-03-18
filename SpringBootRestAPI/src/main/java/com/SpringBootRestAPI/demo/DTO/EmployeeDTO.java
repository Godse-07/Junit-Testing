package com.SpringBootRestAPI.demo.DTO;

import com.SpringBootRestAPI.demo.Entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private String email;
    private String fullName;
    private String mobile;
    private String officeName;
    private double salary;

    private List<AddressDTO> address;
}
