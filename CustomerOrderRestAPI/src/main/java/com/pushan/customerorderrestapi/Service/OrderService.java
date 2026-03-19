package com.pushan.customerorderrestapi.Service;

import com.pushan.customerorderrestapi.DTO.OrderDTO;

public interface OrderService {
    OrderDTO createOrder(long customerId, OrderDTO order);
    OrderDTO getOrderDetails(long orderId);
}
