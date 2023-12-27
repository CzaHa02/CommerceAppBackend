package com.commerceAppBackEnd.backend.mapper;

import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.dto.CustomerDto;
import com.commerceAppBackEnd.backend.dto.OrderDto;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getOrderName(),
                orderDto.getDate(),
                orderDto.getOrderCode(),
                orderDto.getCustomer(),
                orderDto.getDescription(),
                orderDto.getQuantity()

        );

    }

    public OrderDto mapToOrderDto(final  Order   order){
        return new OrderDto(
                order.getId(),
                order.getOrderName(),
                order.getDate(),
                order.getOrderCode(),
                order.getCustomer(),
                order.getDescription(),
                order.getQuantity()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order>orderList){
        return orderList.stream()
                .map(this::mapToOrderDto)
                .toList();
    }
}


