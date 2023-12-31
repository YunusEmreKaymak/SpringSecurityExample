package com.yunus.springsecurityexample.controller;

import com.yunus.springsecurityexample.dto.ProductDto;
import com.yunus.springsecurityexample.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void addProduct(ProductDto productDto) {
        productService.addProduct(productDto);
    }
}
