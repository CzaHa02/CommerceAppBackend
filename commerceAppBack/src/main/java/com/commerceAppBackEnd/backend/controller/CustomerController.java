package com.commerceAppBackEnd.backend.controller;

import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.dto.CustomerDto;

import com.commerceAppBackEnd.backend.mapper.CustomerMapper;
import com.commerceAppBackEnd.backend.repository.CustomerRepository;
import com.commerceAppBackEnd.backend.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/customers")
public class CustomerController {

    private final DbService service;
    private final CustomerMapper customerMapper;


    @GetMapping
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = service.getAllCustomers();
        return customerMapper.mapToCustomerDtoList(customers);
    }

    @DeleteMapping(value = "{deleteCustomerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long deleteCustomerId) throws  CustomerNotFoundException {
        service.deleteCustomer(deleteCustomerId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerMapper.mapToCustomerDto(service.getCustomer(customerId)));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        Customer customer = customerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = service.saveCustomer(customer);
        return ResponseEntity.ok(customerMapper.mapToCustomerDto(savedCustomer));

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerMapper.mapToCustomer(customerDto);
        service.saveCustomer(customer);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerDto>> searchCustomersByName(@RequestParam String name) {
        List<Customer> customers = service.searchCustomersByName(name);
        return ResponseEntity.ok(customerMapper.mapToCustomerDtoList(customers));
    }


    @DeleteMapping(value = "{customerId}")
    public ResponseEntity<Void> deleteCustomer(@RequestBody Long customerId){
        return ResponseEntity.ok().build();

    }
}
