package com.ecomerce.core.domain.usecase;

import com.ecomerce.core.application.rest.request.PriceRequest;
import com.ecomerce.core.domain.Price;

import java.util.Optional;

public interface UseCaseFinder {
    Optional<Price> findCurrentPriceBeingApplied(PriceRequest request);
}
