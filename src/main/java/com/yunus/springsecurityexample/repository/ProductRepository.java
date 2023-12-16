package com.yunus.springsecurityexample.repository;

import com.yunus.springsecurityexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByProductName(String productName);
}
