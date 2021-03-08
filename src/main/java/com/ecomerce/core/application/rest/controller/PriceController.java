package com.ecomerce.core.application.rest.controller;

import com.ecomerce.core.application.rest.request.PriceRequest;
import com.ecomerce.core.application.rest.request.parser.QueryablePriceRequestParser;
import com.ecomerce.core.application.rest.response.PriceResponse;
import com.ecomerce.core.application.rest.presenter.PriceRestPresenter;
import com.ecomerce.core.domain.usecase.UseCaseFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {
    private final UseCaseFinder finder;

    @GetMapping("/applied")
    ResponseEntity<PriceResponse> findCurrentPriceBeingApplied(HttpServletRequest request) {
        PriceRequest priceRequest = QueryablePriceRequestParser.parse(request);
        return ResponseEntity.ok(
                finder.findCurrentPriceBeingApplied(priceRequest)
                        .map(PriceRestPresenter::asRest)
                        .orElseThrow(NoSuchElementException::new));
    }
    //TODO: Finish Exception Handling
}
