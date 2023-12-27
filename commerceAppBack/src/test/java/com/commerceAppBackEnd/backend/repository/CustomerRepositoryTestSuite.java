package com.commerceAppBackEnd.backend.repository;
import com.commerceAppBackEnd.backend.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTestSuite {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer1;

    @BeforeEach
    public void setUp() {
        customer1 = Customer.builder()
                .customerName("Customer 1")
                .customerSurname("CustomerSurname 1")
                .nameOfCustomerCompany("Customer company 1")
                .id(1L)
                .Email("customer@mail")
                .NIP(1)
                .build();

        customerRepository.save(customer1);
    }

    @AfterEach
    public void cleanUp() {
        customerRepository.deleteAll();
    }

    @Test
    void shouldFindAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        assertNotNull(customerList);
        assertEquals(1, customerList.size());
    }

    @Test
    void shouldUpdateCustomer() {
        assertEquals("Customer 1", customer1.getCustomerName());
        customer1.setCustomerName("Updated Customer");
        assertEquals("Updated Customer", customer1.getCustomerName());
    }

    @Test
    void shouldFindCustomerByID() {
        Optional<Customer> customerById = customerRepository.findById(customer1.getId());
        assertTrue(customerById.isPresent());
        assertEquals(customer1.getId(), customerById.get().getId());
    }

    @Test
    void shouldDeleteCustomer() {
        customerRepository.deleteById(customer1.getId());
        assertFalse(customerRepository.existsById(customer1.getId()));
    }
}