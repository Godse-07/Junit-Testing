package com.pushan.restapis.Employee_address.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    @Pattern(regexp = "^[0-9]{6}$", message = "Zip code should be 5 digits")
    private String pincode;
}
