package com.cartflux.orderfulfillment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private LocalDateTime placedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<OrderLineItem> lineItems = new LinkedHashSet<>();

    protected PurchaseOrder() {
    }

    public PurchaseOrder(String customerEmail, LocalDateTime placedAt, OrderStatus status) {
        this.customerEmail = customerEmail;
        this.placedAt = placedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Set<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItem(Product product, int quantity, java.math.BigDecimal lockedPrice) {
        OrderLineItem lineItem = new OrderLineItem(this, product, quantity, lockedPrice);
        lineItems.add(lineItem);
        product.getLineItems().add(lineItem);
    }
}
