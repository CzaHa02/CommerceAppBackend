package com.commerceAppBackEnd.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "orderName")
    private String orderName;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "orderCode")
    private int orderCode;

    @Column(name = "customer")
    private String customer;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;


}
