package com.SpringBootRestAPI.demo.DTO;

import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String state;
    private String pincode;
}