package com.ecomerce.core.domain.repository;

import com.ecomerce.core.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findApplicablePrices(LocalDateTime effectiveDate, Long brandId, Long productId);
}
