package com.yunus.springsecurityexample.service;

import com.yunus.springsecurityexample.dto.ProductDto;
import com.yunus.springsecurityexample.dto.ProductDtoConverter;
import com.yunus.springsecurityexample.model.Product;
import com.yunus.springsecurityexample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoConverter dtoConverter;

    public ProductService(ProductRepository productRepository, ProductDtoConverter dtoConverter) {
        this.productRepository = productRepository;
        this.dtoConverter = dtoConverter;
    }

    public List<ProductDto> getProducts() {
       return productRepository.findAll().stream().map(dtoConverter::productToProductDto).toList();
    }

    public void addProduct(ProductDto productDto) {
        if (productRepository.existsByProductName(productDto.getProductName())) {
            throw new RuntimeException("Product already exist");
        }
        productRepository.save(new Product(productDto.getProductName(),productDto.getPrice(), productDto.getImageUrl(), productDto.getStockAmount()));
    }
}
