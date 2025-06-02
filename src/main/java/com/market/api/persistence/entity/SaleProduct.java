package com.market.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sale_product")
public @Data class SaleProduct {
    @EmbeddedId
    private SaleProductPK id;
    private Integer quantity;
    private Double total;
    private Boolean state;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id", insertable = false, updatable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}
