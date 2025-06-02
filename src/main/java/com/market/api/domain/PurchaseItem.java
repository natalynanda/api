package com.market.api.domain;

import lombok.Data;

public @Data class PurchaseItem {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;
}
