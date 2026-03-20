package com.pushan.customerorderrestapi.Service.Implementation;

import com.pushan.customerorderrestapi.DTO.CustomerDTO;
import com.pushan.customerorderrestapi.Entity.Customer;
import com.pushan.customerorderrestapi.Entity.Order;
import com.pushan.customerorderrestapi.Mapper.Mapper;
import com.pushan.customerorderrestapi.Repository.CustomerRepository;
import com.pushan.customerorderrestapi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public CustomerDTO getCustomerById(long id) {
        return customerRepository.findById(id)
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .toList();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = mapper.map(customerDTO, Customer.class);
        if (customer.getOrders() != null) {
            for (Order order : customer.getOrders()) {
                order.setCustomer(customer);
            }
        }
        Customer saved = customerRepository.save(customer);
        return mapper.map(saved, CustomerDTO.class);
    }
}
