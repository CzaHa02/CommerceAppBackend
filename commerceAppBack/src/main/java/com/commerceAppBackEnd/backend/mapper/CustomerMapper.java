package com.commerceAppBackEnd.backend.mapper;

import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerMapper {

    public Customer mapToCustomer(final CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerSurname(),
                customerDto.getNIP(),
                customerDto.getEmail(),
                customerDto.getNameOfCustomerCompany()
        );

    }

    public CustomerDto mapToCustomerDto(final  Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCustomerSurname(),
                customer.getNIP(),
                customer.getEmail(),
                customer.getNameOfCustomerCompany()
        );
    }

    public List<CustomerDto> mapToCustomerDtoList(final List<Customer>customerList){
        return customerList.stream()
                .map(this::mapToCustomerDto)
                .toList();
    }
}
