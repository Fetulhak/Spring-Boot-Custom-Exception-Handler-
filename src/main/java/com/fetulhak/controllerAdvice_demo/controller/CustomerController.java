package com.fetulhak.controllerAdvice_demo.controller;

import com.fetulhak.controllerAdvice_demo.entity.Customer;
import com.fetulhak.controllerAdvice_demo.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    List<Customer> customers = Arrays.asList(new Customer(1L,"dawit"),
            new Customer(2L,"abebe"),
            new Customer(3L, "kebede"));


    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/get/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomer( @PathVariable("customerId") Long id) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getId() == id).findFirst();

        if (customer.isPresent()) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            throw new CustomerNotFoundException("The customer with id: " + id + " is not found");
        }


    }
}