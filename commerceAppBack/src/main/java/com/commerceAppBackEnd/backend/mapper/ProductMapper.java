package com.commerceAppBackEnd.backend.mapper;

import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.domain.Product;
import com.commerceAppBackEnd.backend.dto.OrderDto;
import com.commerceAppBackEnd.backend.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductMapper {

    public Product mapToProduct(final ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getCode(),
                productDto.getQuantity(),
                productDto.getPrice(),
                productDto.getStatus()

        );

    }

    public ProductDto mapToProductDto(final  Product   product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getCode(),
                product.getQuantity(),
                product.getPrice(),
                product.getStatus()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product>productList){
        return productList.stream()
                .map(this::mapToProductDto)
                .toList();
    }
}




