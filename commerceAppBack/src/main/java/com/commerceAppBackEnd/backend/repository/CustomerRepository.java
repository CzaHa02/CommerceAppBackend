package com.commerceAppBackEnd.backend.repository;

import com.commerceAppBackEnd.backend.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<Customer> findAll();

    @Override
    Customer save(Customer customer);

    @Override
    Optional<Customer> findById(Long id);

    @Query("select c from customer c " +
            "where lower(c.customerName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.customerSurname) like lower(concat('%', :searchTerm, '%'))")
    List<Customer> search(@Param("searchTerm") String searchTerm);

    void deleteById(Long id);
    List<Customer> findByNameContainingIgnoreCase(String name);


}

