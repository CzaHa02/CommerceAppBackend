package com.commerceAppBackEnd.backend.repository;


import com.commerceAppBackEnd.backend.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryTestSuite {


    @Autowired
    private ProductRepository productRepository;

    private Product product1;


    @BeforeEach
    public void setUp() {
        product1 = Product.builder()
                .name("Prodcut 1")
                .status("Status 1")
                .price(1)
                .quantity(1)
                .code(1234)
                .build();
        productRepository.save(product1);


    }
    @AfterEach
    public void cleanUp() {
        productRepository.deleteAll();
    }

    @Test
    void shouldFindAllProducts(){
        List<Product> productList = productRepository.findAll();
        assertNotNull(productList);
        assertEquals(1,productList.size());

    }

    @Test
    void shouldUpdateProduct(){
        assertEquals("Prodcut 1", product1.getName());
        product1.setName("Product 1 new");
        assertEquals("Product 1 new", product1.getName());
    }

    @Test
    void shouldFindProductByID(){
            Optional<Product> productById =productRepository.findById(product1.getId());
            assertTrue(productById.isPresent());
            assertEquals(product1.getId(), productById.get().getId());
        }

        @Test
    void shouldDeleteProduct(){
        productRepository.deleteById(product1.getId());
        assertFalse(productRepository.existsById(product1.getId()));
        }
  }

