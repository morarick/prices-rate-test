package com.ecomerce.core.application.rest.request.parser;

import com.ecomerce.core.application.rest.exception.BadRequestException;
import com.ecomerce.core.application.rest.request.PriceRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QueryablePriceRequestParser {
    public static PriceRequest parse(HttpServletRequest request) {
        return PriceRequest.builder()
                .effectiveDate(dateTimeFromString(request.getParameter("effectiveDate")))
                .productId(longFromString(request.getParameter("productId")))
                .brandId(longFromString(request.getParameter("brandId")))
                .build();
    }

    private static LocalDateTime dateTimeFromString(String date) throws BadRequestException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return LocalDateTime.parse(date, formatter);
        } catch (Exception e){
            throw new BadRequestException();
        }
    }

    private static Long longFromString(String param) throws BadRequestException {
        try {
            return Long.valueOf(param);
        } catch (Exception e){
            throw new BadRequestException();
        }
    }
}
