package com.yunus.springsecurityexample.dto;

public class ProductDto {
    private String productName;
    private Double price;
    private String imageUrl;
    private int stockAmount;

    public ProductDto(String productName, Double price, String imageUrl, int stockAmount) {
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stockAmount = stockAmount;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
