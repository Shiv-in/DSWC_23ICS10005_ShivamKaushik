package com.cartflux.orderfulfillment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "order_line_items")
public class OrderLineItem {

    @EmbeddedId
    private OrderLineItemId id;

    @MapsId("purchaseOrderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal lockedPrice;

    protected OrderLineItem() {
    }

    public OrderLineItem(PurchaseOrder purchaseOrder, Product product, int quantity, BigDecimal lockedPrice) {
        this.purchaseOrder = purchaseOrder;
        this.product = product;
        this.quantity = quantity;
        this.lockedPrice = lockedPrice;
        this.id = new OrderLineItemId();
    }

    public OrderLineItemId getId() {
        return id;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLockedPrice() {
        return lockedPrice;
    }
}
