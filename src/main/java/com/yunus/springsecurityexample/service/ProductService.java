package com.yunus.springsecurityexample.service;

import com.yunus.springsecurityexample.model.Product;
import com.yunus.springsecurityexample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        if (productRepository.existsById(product.getProductId())) {
            throw new RuntimeException("Product already exist");
        }
        productRepository.save(product);
    }
}
