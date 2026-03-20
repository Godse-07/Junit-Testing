package com.pushan.restapis.Employee_address.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    @NotBlank(message = "Name can not be blank")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobile;
    private String gender;
    private String designation;
    @Positive(message = "Salary should be positive")
    private double salary;
    private LocalDate dateOfJoining;
    private AddressDTO address;
}
