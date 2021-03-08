package com.ecomerce.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
public class Price {
    private Long priceList;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private int priority;
    private float value;
    private String currency;

    public static Optional<Price> selectHighestPriorityPrice(List<Price> prices){
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority));
    }
}
