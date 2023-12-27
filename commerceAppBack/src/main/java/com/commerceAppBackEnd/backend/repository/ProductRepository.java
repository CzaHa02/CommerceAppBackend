package com.commerceAppBackEnd.backend.repository;

import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {



    @Query("select c from product c " +
            "where lower(c.name) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(c.status) like lower(concat('%', :searchTerm, '%'))")
    List<Product> search(@Param("searchTerm") String searchTerm);


    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

    void deleteById(Long id);

    List<Product> findByNameContainingIgnoreCase(String name);



}
