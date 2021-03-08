package com.ecomerce.core.application.usecases;

import com.ecomerce.core.application.rest.request.PriceRequest;
import com.ecomerce.core.domain.Price;
import com.ecomerce.core.domain.repository.PriceRepository;
import com.ecomerce.core.domain.usecase.UseCaseFinder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceFinder implements UseCaseFinder {

    private final PriceRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceFinder.class);

    public Optional<Price> findCurrentPriceBeingApplied(PriceRequest request) {
        List<Price> prices = repository.findApplicablePrices(request.getEffectiveDate(), request.getBrandId(), request.getProductId());
        return Optional.of(prices)
                .flatMap(Price::selectHighestPriorityPrice);
    }
}
