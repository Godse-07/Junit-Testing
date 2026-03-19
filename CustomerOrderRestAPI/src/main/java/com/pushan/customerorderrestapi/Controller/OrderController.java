package com.pushan.customerorderrestapi.Controller;

import com.pushan.customerorderrestapi.DTO.OrderDTO;
import com.pushan.customerorderrestapi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderDetails/{orderId}")
    public OrderDTO getOrderDetails(@PathVariable long orderId) {
        return orderService.getOrderDetails(orderId);
    }

    @PostMapping("/createOrder/{customerId}")
    public OrderDTO createOrderForCustomer(@PathVariable long customerId, @RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(customerId, orderDTO);
    }
}
