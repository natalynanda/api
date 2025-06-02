package com.market.api.domain;

import lombok.Data;

public @Data class ProductDto {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private CategoryDto categoryDto;

    public static class Purchase {
    }
}
