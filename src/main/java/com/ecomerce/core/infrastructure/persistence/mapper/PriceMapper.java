package com.ecomerce.core.infrastructure.persistence.mapper;

import com.ecomerce.core.domain.Price;
import com.ecomerce.core.infrastructure.persistence.model.PriceModel;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public static PriceModel mapFromEntity(final Price price) {
        return PriceModel.builder()
                .priceList(price.getPriceList())
                .brandId(price.getBrandId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .productId(price.getProductId())
                .priority(price.getPriority())
                .value(price.getValue())
                .build();
    }

    public static Price mapFromModel(final PriceModel model) {
        return Price.builder()
                .priceList(model.getPriceList())
                .brandId(model.getBrandId())
                .startDate(model.getStartDate())
                .endDate(model.getEndDate())
                .productId(model.getProductId())
                .priority(model.getPriority())
                .value(model.getValue())
                .build();
    }

}
