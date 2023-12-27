package com.commerceAppBackEnd.backend.repository;

import com.commerceAppBackEnd.backend.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    private Order order1;

    @BeforeEach
    public void setUp() {
        order1 = Order.builder()
                .orderName("Order 1")
                .customer("Customer 1")
                .id(1L)
                .orderCode(1)
                .date(LocalDate.now())
                .description("description 1")
                .quantity(1)
                .build();

        orderRepository.save(order1);
    }

    @AfterEach
    public void cleanUp() {
        orderRepository.deleteAll();
    }

    @Test
    void shouldFindAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        assertNotNull(orderList);
        assertEquals(1, orderList.size());
    }

    @Test
    void shouldUpdateOrder() {
        assertEquals(1, order1.getOrderCode());
        order1.setOrderCode(12345);
        assertEquals(12345, order1.getOrderCode());
    }

    @Test
    void shouldFindOrderByID() {
        Optional<Order> orderById = orderRepository.findById(order1.getId());
        assertTrue(orderById.isPresent());
        assertEquals(order1.getId(), orderById.get().getId());
    }

    @Test
    void shouldDeleteOrder(){
        orderRepository.deleteById(order1.getId());
        assertFalse(orderRepository.existsById(order1.getId()));
    }
}