package com.belrose.jmeter.controller;

import com.belrose.jmeter.model.Product;
import com.belrose.jmeter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        var response = service.saveProduct(product);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        var response = service.saveProducts(products);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {
        var response = service.getProducts();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> findProductById(@RequestHeader int id) {
        var response = service.getProductById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<Product> findProductByName(@RequestHeader String name) {
        var response = service.getProductByName(name);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        var response = service.updateProduct(product);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestHeader int id) {
        var response = service.deleteProduct(id);
        return ResponseEntity.ok().body(response);
    }
}
