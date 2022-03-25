package com.backend.backendiprwc.service;

import com.backend.backendiprwc.exception.ResourceNotFoundException;
import com.backend.backendiprwc.model.Product;
import com.backend.backendiprwc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ResourceNotFoundException("Product", "Id", id);
        }    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Id", id));
        existingProduct.setName(product.getName());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setSeller(product.getSeller());
        existingProduct.setEAN(product.getEAN());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImgPath(product.getImgPath());

        //Save to db
        productRepository.save(existingProduct);

        return existingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        //Check whether product exists in db
        productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }
}
