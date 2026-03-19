package com.pushan.customerorderrestapi.Controller;

import com.pushan.customerorderrestapi.DTO.CustomerDTO;
import com.pushan.customerorderrestapi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDTO getCustomerbyId(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getAll")
    public List<CustomerDTO> getgetAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

}
