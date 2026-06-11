package com.cartflux.orderfulfillment.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderLineItemId implements Serializable {

    @Column(name = "order_id")
    private Long purchaseOrderId;

    @Column(name = "product_id")
    private Long productId;

    protected OrderLineItemId() {
    }

    public OrderLineItemId(Long purchaseOrderId, Long productId) {
        this.purchaseOrderId = purchaseOrderId;
        this.productId = productId;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public Long getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderLineItemId that = (OrderLineItemId) o;
        return Objects.equals(purchaseOrderId, that.purchaseOrderId)
            && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseOrderId, productId);
    }
}
