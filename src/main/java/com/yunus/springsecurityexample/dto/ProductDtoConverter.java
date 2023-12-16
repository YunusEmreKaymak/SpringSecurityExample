package com.yunus.springsecurityexample.dto;

import com.yunus.springsecurityexample.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {
    public ProductDto productToProductDto(Product product) {
        return new ProductDto(product.getProductName(), product.getPrice(), product.getImageUrl(), product.getStockAmount());
    }
}
