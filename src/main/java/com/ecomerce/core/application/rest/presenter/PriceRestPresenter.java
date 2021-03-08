package com.ecomerce.core.application.rest.presenter;

import com.ecomerce.core.application.rest.response.PriceResponse;
import com.ecomerce.core.domain.Price;

public class PriceRestPresenter {

    public static PriceResponse asRest(Price price){
        return PriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .value(price.getValue())
                .build();
    };
}
