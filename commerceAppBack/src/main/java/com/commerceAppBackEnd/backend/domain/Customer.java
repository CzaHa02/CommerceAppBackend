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
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerSurname")
    private String customerSurname;

    @Column(name = "NIP")
    private int NIP;

    @Column(name = "Email")
    private String Email;

    @Column(name = "nameOfCustomerCompany")
    private String nameOfCustomerCompany;
}
