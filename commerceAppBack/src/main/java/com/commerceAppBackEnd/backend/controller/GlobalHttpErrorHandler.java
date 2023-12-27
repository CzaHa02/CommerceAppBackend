package com.commerceAppBackEnd.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object>handleCustomerNotFoundException ( CustomerNotFoundException exception){
        return new ResponseEntity<>("Customer with current id doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object>handleProductNotFoundException ( ProductNotFoundException exception){
        return new ResponseEntity<>("Product with current id  doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object>handleOrderNotFoundException ( OrderNotFoundException exception){
        return new ResponseEntity<>("Order with current id  doesn't exist", HttpStatus.BAD_REQUEST);
    }
}


