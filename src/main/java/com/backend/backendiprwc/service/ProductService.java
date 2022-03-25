package com.backend.backendiprwc.service;

import com.backend.backendiprwc.model.Product;

import java.util.List;
public interface ProductService {
    void saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product updateProduct(Product product, long id);

    void deleteProduct(long id);
}
