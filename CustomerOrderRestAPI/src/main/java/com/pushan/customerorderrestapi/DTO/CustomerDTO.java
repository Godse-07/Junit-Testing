package com.pushan.customerorderrestapi.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private String name;
    private String email;
    private List<OrderDTO> orders;
}
