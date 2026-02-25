package com.TestAssignment1.Assignment1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService os = new OrderService();

    // Only NEW should be cancellable
    @ParameterizedTest
    @EnumSource(value = OrderStatus.class, names = "NEW")
    void shouldAllowCancelWhenStatusIsNew(OrderStatus status) {
        assertTrue(os.canCancel(status));
    }

    // All other statuses should NOT be cancellable
    @ParameterizedTest
    @EnumSource(value = OrderStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "NEW")
    void shouldNotAllowCancelWhenStatusIsNotNew(OrderStatus status) {
        assertFalse(os.canCancel(status));
    }
}