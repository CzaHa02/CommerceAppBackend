package com.commerceAppBackEnd.backend.controller;

import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.domain.Product;
import com.commerceAppBackEnd.backend.dto.OrderDto;
import com.commerceAppBackEnd.backend.dto.ProductDto;
import com.commerceAppBackEnd.backend.mapper.ProductMapper;
import com.commerceAppBackEnd.backend.repository.ProductRepository;
import com.commerceAppBackEnd.backend.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/v2/products")
@RestController
public class ProductController {


ProductRepository productRepository;
    private final DbService service;
    private final ProductMapper productMapper;


    @GetMapping
    public List<ProductDto> getProducts() {
        List<Product> products= service.getAllProducts();
        return productMapper.mapToProductDtoList(products);
    }

    @DeleteMapping(value = "{deleteProductId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long deleteProductId) throws  ProductNotFoundException {
        service.deleteProduct(deleteProductId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return  ResponseEntity.ok(productMapper.mapToProductDto(service.getProduct(productId)));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(productMapper.mapToProductDto(savedProduct));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct (@RequestBody ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        service.saveProduct(product);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@RequestBody Long productId){
        return ResponseEntity.ok().build();

    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProductsByName(@RequestParam String name) {
        List<Product> products = service.searchProductsByName(name);
        return ResponseEntity.ok(productMapper.mapToProductDtoList(products));
    }

}
