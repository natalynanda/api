package com.market.api.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "client")
public @Data class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private Long cellphone;
    private String address;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales;
}
