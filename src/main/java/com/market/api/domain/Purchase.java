package com.market.api.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public @Data class Purchase {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;
}
