package com.commerceAppBackEnd.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int code;
    private int quantity;
    private double price;
    private String status;
}
