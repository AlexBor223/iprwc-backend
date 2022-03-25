package com.backend.backendiprwc.controller;


import com.backend.backendiprwc.model.Product;
import com.backend.backendiprwc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //REST API create product.
    @PostMapping()
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        System.out.println(product.toString());
        productService.saveProduct(product);
        return new ResponseEntity<>("product added", HttpStatus.OK);
    }

    //REST API get all products.
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //REST API get one specific product. URI: /api/products/1
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) {
        return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
    }

    //REST API build an update for one product. URI: /api/products/1
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    //REST API delete on product URI: /api/products/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product deletion successful", HttpStatus.OK);
    }

}