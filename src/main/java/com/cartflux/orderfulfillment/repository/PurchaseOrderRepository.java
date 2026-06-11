package com.cartflux.orderfulfillment.repository;

import com.cartflux.orderfulfillment.domain.PurchaseOrder;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    @Query("""
        select distinct po
        from PurchaseOrder po
        join fetch po.lineItems li
        join fetch li.product
        where po.status = com.cartflux.orderfulfillment.domain.OrderStatus.PENDING
        """)
    List<PurchaseOrder> findAllPendingWithLineItemsAndProducts();

    List<PurchaseOrder> findByPlacedAtBetweenAndCustomerEmailEndingWith(
        LocalDateTime start,
        LocalDateTime end,
        String emailDomain
    );
}
