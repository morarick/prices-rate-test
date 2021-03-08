package com.ecomerce.core.infrastructure.persistence.datasource;

import com.ecomerce.core.infrastructure.persistence.model.PriceModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDatasource extends CrudRepository<PriceModel, Long> {
    @Query("SELECT p FROM PriceModel p WHERE p.startDate <= :effectiveDate AND p.endDate >= :effectiveDate AND p.brandId = :brandId AND p.productId = :productId")
    List<PriceModel> findApplicablePrices(LocalDateTime effectiveDate, Long brandId, Long productId);
}
