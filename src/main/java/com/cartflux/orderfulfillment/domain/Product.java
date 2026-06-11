package com.cartflux.orderfulfillment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal currentPrice;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderLineItem> lineItems = new LinkedHashSet<>();

    protected Product() {
    }

    public Product(String sku, String name, BigDecimal currentPrice) {
        this.sku = sku;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public Set<OrderLineItem> getLineItems() {
        return lineItems;
    }
}
