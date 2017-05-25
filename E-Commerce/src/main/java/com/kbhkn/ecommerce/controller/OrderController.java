package com.kbhkn.ecommerce.controller;

import com.kbhkn.ecommerce.domain.Order;
import com.kbhkn.ecommerce.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kbhkn on 4/30/17.
 */
@RestController
@RequestMapping("/api/service/order")
public class OrderController {
    private Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    GenericService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getAllOrders() {
        return new ResponseEntity<Object>(service.findAll(Order.class), HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addOrder(@RequestBody Order order) {
        log.info("Creation new order --> {}", order);
        order.setOrderDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        service.save(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateOrder(@RequestBody Order order) {
        log.info("Updating order --> {}", order);
        service.update(order);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id") Integer id) {
        log.info("Delete order by id --> {}", id);
        service.delete(Order.class, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
