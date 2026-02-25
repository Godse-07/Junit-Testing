package com.TestAssignment1.Assignment1;

public class OrderService {
    public boolean canCancel(OrderStatus status) {
        return status == OrderStatus.NEW;
    }
}
