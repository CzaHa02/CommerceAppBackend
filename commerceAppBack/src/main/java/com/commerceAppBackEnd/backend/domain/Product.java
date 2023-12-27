package com.commerceAppBackEnd.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "productName")
    private String name;

    @Column(name = "code")
    private int code;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

}
