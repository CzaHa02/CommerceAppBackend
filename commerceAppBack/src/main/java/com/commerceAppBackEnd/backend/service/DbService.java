package com.commerceAppBackEnd.backend.service;

import com.commerceAppBackEnd.backend.controller.CustomerNotFoundException;
import com.commerceAppBackEnd.backend.controller.OrderNotFoundException;
import com.commerceAppBackEnd.backend.controller.ProductNotFoundException;
import com.commerceAppBackEnd.backend.domain.Customer;
import com.commerceAppBackEnd.backend.domain.Order;
import com.commerceAppBackEnd.backend.domain.Product;
import com.commerceAppBackEnd.backend.repository.CustomerRepository;
import com.commerceAppBackEnd.backend.repository.OrderRepository;
import com.commerceAppBackEnd.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DbService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;



    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Order> getAllOrders() {return orderRepository.findAll();
    }


    public Customer getCustomer(final Long customerId) throws CustomerNotFoundException {return customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
    }

    public Product getProduct(final Long productId) throws ProductNotFoundException { return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public Order getOrder(final Long orderId) throws OrderNotFoundException { return orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }



    public Customer saveCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }



    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }



    public void deleteOrder(Long id) throws OrderNotFoundException {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        orderRepository.deleteById(id);}

        public void deleteProduct(Long id) throws ProductNotFoundException {
            if (!productRepository.existsById(id)) {
                throw new ProductNotFoundException();
            }
            productRepository.deleteById(id);}


            public void deleteCustomer(Long id) throws CustomerNotFoundException {
                if (!customerRepository.existsById(id)) {
                    throw new CustomerNotFoundException();
                }
                orderRepository.deleteById(id);}

    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Order> searchOrdersByName(String name) {
        return orderRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}



