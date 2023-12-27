package com.commerceAppBackEnd.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String orderName;
    private LocalDate date;
    private int orderCode;
    private String customer;
    private String description;
    private int quantity;


}