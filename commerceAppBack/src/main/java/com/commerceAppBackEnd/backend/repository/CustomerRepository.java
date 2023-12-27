package com.commerceAppBackEnd.backend.repository;

import com.commerceAppBackEnd.backend.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();

    @Override
    Customer save(Customer customer);

    @Override
    Optional<Customer> findById(Long id);

    @Query("SELECT c FROM customer c " +
            "WHERE LOWER(c.customerName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(c.customerSurname) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);

    void deleteById(Long id);

    List<Customer> findCustomerByCustomerNameContainingIgnoreCase(String name);
}