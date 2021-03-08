package com.ecomerce.core.infrastructure.persistence.repository;

import com.ecomerce.core.domain.Price;
import com.ecomerce.core.infrastructure.persistence.datasource.PriceDatasource;
import com.ecomerce.core.infrastructure.persistence.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PriceRepository implements com.ecomerce.core.domain.repository.PriceRepository {

    private final PriceDatasource datasource;

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceRepository.class);

    @Override
    public List<Price> findApplicablePrices(LocalDateTime effectiveDate, Long brandId, Long productId) {
        LOGGER.info("searching for applicable prices");
        List<Price> prices = datasource.findApplicablePrices(effectiveDate, brandId, productId)
                .stream()
                .map(PriceMapper::mapFromModel)
                .collect(Collectors.toList());
        LOGGER.info("applicable prices retrieved");
        return prices;
    }
}
