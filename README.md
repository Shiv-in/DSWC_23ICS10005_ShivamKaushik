# DSWC_23ICS10005_ShivamKaushik

CartFlux Order Fulfillment Engine

A minimal Spring Boot + Spring Data JPA sample that models CartFlux's order fulfillment flow.

## What is included

- `PurchaseOrder`, `Product`, and `OrderLineItem` entities
- Composite primary key for `OrderLineItem` via `@Embeddable` and `@EmbeddedId`
- `@MapsId`-based many-to-many payload mapping
- A fetch-join repository query that loads pending orders, line items, and products in one JPQL query
- A derived Spring Data query for date range plus email domain filtering

## Run

```bash
mvn spring-boot:run
```
