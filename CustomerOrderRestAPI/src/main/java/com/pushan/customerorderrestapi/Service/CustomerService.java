package com.pushan.customerorderrestapi.Service;

import com.pushan.customerorderrestapi.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(long id);
    List<CustomerDTO> getAllCustomer();
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}
