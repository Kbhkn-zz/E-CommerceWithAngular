package com.kbhkn.ecommerce.controller;

import com.kbhkn.ecommerce.domain.Customer;
import com.kbhkn.ecommerce.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kbhkn on 4/30/17.
 */
@RestController
@RequestMapping("/api/service/customer")
public class CustomerController {
    private Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    GenericService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity<Object>(service.findAll(Customer.class), HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        log.info("Creation new customer --> {}", customer);
        service.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        log.info("Updating customer --> {}", customer);
        service.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Integer id) {
        log.info("Delete customer by id --> {}", id);
        service.delete(Customer.class, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
