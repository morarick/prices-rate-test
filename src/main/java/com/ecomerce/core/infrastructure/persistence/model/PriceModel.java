package com.ecomerce.core.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceModel {

    @Id
    @Column(name = "price_list")
    private Long priceList;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "value")
    private float value;

    @Column(name = "currency")
    private String currency;
}
