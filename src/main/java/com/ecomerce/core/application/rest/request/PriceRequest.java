package com.ecomerce.core.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class PriceRequest {
    private LocalDateTime effectiveDate;
    private Long productId;
    private Long brandId;
}
