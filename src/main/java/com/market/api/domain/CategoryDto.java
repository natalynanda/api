package com.market.api.domain;

import lombok.Data;

public @Data class CategoryDto {
    private int categoryId;
    private String category;
    private boolean active;
}
