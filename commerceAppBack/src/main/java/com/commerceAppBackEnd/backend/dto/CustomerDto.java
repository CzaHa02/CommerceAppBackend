package com.commerceAppBackEnd.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String customerName;
    private String customerSurname;
    private int NIP;
    private String Email;
    private String nameOfCustomerCompany;
}
