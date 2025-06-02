package com.market.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
public @Data class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    private String description;
    private Boolean active;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
