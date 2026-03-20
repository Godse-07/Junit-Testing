package com.pushan.restapis.Employee_address.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String state;
    private String country;

    @Pattern(regexp = "^[0-9]{6}$", message = "Zip code should be 5 digits")
    private String pincode;
}
