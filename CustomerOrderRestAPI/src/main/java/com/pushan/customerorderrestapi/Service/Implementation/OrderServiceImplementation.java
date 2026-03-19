package com.pushan.customerorderrestapi.Service.Implementation;

import com.pushan.customerorderrestapi.DTO.OrderDTO;
import com.pushan.customerorderrestapi.Entity.Customer;
import com.pushan.customerorderrestapi.Entity.Order;
import com.pushan.customerorderrestapi.Mapper.Mapper;
import com.pushan.customerorderrestapi.Repository.CustomerRepository;
import com.pushan.customerorderrestapi.Repository.OrderRepository;
import com.pushan.customerorderrestapi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderDTO createOrder(long customerId, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(
                        () -> new RuntimeException("No customer found with id: " + customerId)
                );
        Order order = mapper.map(orderDTO, Order.class);
        order.setCustomer(customer);
        Order savedOrder = orderRepository.save(order);
        return mapper.map(savedOrder, OrderDTO.class);
    }

    @Override
    public OrderDTO getOrderDetails(long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("No order found by id: " + orderId));
        return mapper.map(order, OrderDTO.class);
    }
}
