package com.ecomerce.core.application.rest;

import com.ecomerce.core.application.rest.response.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PriceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String appliedPriceUri = "/price/applied?effectiveDate={effectiveDate}&brandId={brandId}&productId={productId}";

    @Test
    public void testAppliedPriceAt_10Hours14DayJacketProductZaraBrand() {
        String effectiveDate = "2020-06-14 10:00:00";
        String productId = "35455";
        String brandId = "1";

        PriceResponse priceResponse = PriceResponse.builder()
                .priceList(1L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .priority(0)
                .value(35.5f)
                .build();

        ResponseEntity<PriceResponse> response = restTemplate
                .getForEntity(appliedPriceUri, PriceResponse.class, effectiveDate, brandId, productId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(priceResponse);
    }

    @Test
    public void testAppliedPriceAt_16Hours14DayJacketProductZaraBrand() {
        String effectiveDate = "2020-06-14 16:00:00";
        String productId = "35455";
        String brandId = "1";

        PriceResponse priceResponse = PriceResponse.builder()
                .priceList(2L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 14, 18, 30, 0))
                .productId(35455L)
                .priority(0)
                .value(25.45f)
                .build();

        ResponseEntity<PriceResponse> response = restTemplate
                .getForEntity(appliedPriceUri, PriceResponse.class, effectiveDate, brandId, productId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(priceResponse);
    }

    @Test
    public void testAppliedPriceAt_21Hours14DayJacketProductZaraBrand() {
        String effectiveDate = "2020-06-14 21:00:00";
        String productId = "35455";
        String brandId = "1";

        PriceResponse priceResponse = PriceResponse.builder()
                .priceList(1L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .priority(0)
                .value(35.5f)
                .build();

        ResponseEntity<PriceResponse> response = restTemplate
                .getForEntity(appliedPriceUri, PriceResponse.class, effectiveDate, brandId, productId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(priceResponse);
    }

    @Test
    public void testAppliedPriceAt_10Hours15DayJacketProductZaraBrand() {
        String effectiveDate = "2020-06-15 10:00:00";
        String productId = "35455";
        String brandId = "1";

        PriceResponse priceResponse = PriceResponse.builder()
                .priceList(3L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 15, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 6, 15, 11, 0, 0))
                .productId(35455L)
                .priority(0)
                .value(30.5f)
                .build();

        ResponseEntity<PriceResponse> response = restTemplate
                .getForEntity(appliedPriceUri, PriceResponse.class, effectiveDate, brandId, productId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(priceResponse);
    }

    @Test
    public void testAppliedPriceAt_21Hours15DayJacketProductZaraBrand() {
        String effectiveDate = "2020-06-15 21:00:00";
        String productId = "35455";
        String brandId = "1";

        PriceResponse priceResponse = PriceResponse.builder()
                .priceList(4L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2020, 6, 15, 16, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(35455L)
                .priority(0)
                .value(38.95f)
                .build();

        ResponseEntity<PriceResponse> response = restTemplate
                .getForEntity(appliedPriceUri, PriceResponse.class, effectiveDate, brandId, productId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(priceResponse);
    }
}
