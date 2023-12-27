package com.commerceAppBackEnd.backend.controller;

import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.domain.Product;
import com.commerceAppBackEnd.backend.dto.CustomerDto;
import com.commerceAppBackEnd.backend.dto.OrderDto;
import com.commerceAppBackEnd.backend.dto.ProductDto;
import com.commerceAppBackEnd.backend.mapper.OrderMapper;
import com.commerceAppBackEnd.backend.repository.OrderRepository;
import com.commerceAppBackEnd.backend.service.DbService;
 import com.commerceAppBackEnd.backend.domain.Order;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@RequestMapping("/v2/orders")
@RestController
public class OrderController {

OrderRepository orderRepository;
    private final DbService service;
    private final OrderMapper orderMapper;


    @GetMapping
    public List<OrderDto> getOrders() {
       List<Order>orders=service.getAllOrders();
       return orderMapper.mapToOrderDtoList(orders);
    }


    @GetMapping(value = "{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        return  ResponseEntity.ok(orderMapper.mapToOrderDto(service.getOrder(orderId)));
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        service.saveOrder(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{deleteOrderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long deleteOrderId) throws  OrderNotFoundException {
        service.deleteOrder(deleteOrderId);
        return ResponseEntity.noContent().build();
    }



    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = service.saveOrder(order);
        return ResponseEntity.ok(orderMapper.mapToOrderDto(savedOrder));
    }


    @DeleteMapping(value = "{orderId}")
    public ResponseEntity<Void> deleteOrder(@RequestBody Long orderId){
        return ResponseEntity.ok().build();

    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderDto>> searchOrdersByName(@RequestParam String name) {
        List<Order> orders = service.searchOrdersByName(name);
        return ResponseEntity.ok(orderMapper.mapToOrderDtoList(orders));
    }
}
