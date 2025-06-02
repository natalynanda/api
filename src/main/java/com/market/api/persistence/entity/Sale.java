package com.market.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
public @Data class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Integer saleId;

    @Column(name = "client_id")
    private String clientId;

    private LocalDateTime date;

    @Column(name = "pay_method")
    private String payMethod;
    private String comments;
    private String state;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = {CascadeType.ALL})
    private List<SaleProduct> products;

}
