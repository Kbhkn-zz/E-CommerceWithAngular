package com.kbhkn.ecommerce.controller;

import com.kbhkn.ecommerce.domain.Product;
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
@RequestMapping("/api/service/product")
public class ProductController {
    private Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    GenericService service;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllProducts() {
        return new ResponseEntity<>(service.findAll(Product.class), HttpStatus.OK);
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addProduct(@RequestBody Product product) {
        log.info("Creation new product --> {}", product);
        service.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        log.info("Updating product --> {}", product);
        service.update(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id) {
        log.info("Delete product by id --> {}", id);
        service.delete(Product.class, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
