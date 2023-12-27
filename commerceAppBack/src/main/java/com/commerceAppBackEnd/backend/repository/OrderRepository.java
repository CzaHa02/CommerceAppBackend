package com.commerceAppBackEnd.backend.repository;


import com.commerceAppBackEnd.backend.domain.Customer;

import com.commerceAppBackEnd.backend.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findAll();

    @Override
    Order save(Order order);

    @Override
    Optional<Order> findById(Long id);

    void deleteById(Long id);

    List<Order> findByOrderNameContainingIgnoreCase(String name);
}
