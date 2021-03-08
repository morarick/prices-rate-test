# Prices Challenge

## API
The API was built in *3 hours* using a clean architecture (*DDD*), and *SOLID* principles. The API is very simple. It just receives an input that is used to retrieve the applied price rate for a product that belongs to a brand and given a date, It will search for a product within its time validity. If more than one product matches, we will select the product with the highest priority.

This API exposes an endpint for this requirement:
verb: *GET* | uri: "price/applied" | params: effectiveDate: String, productId: String, brandId: String,

E.g.
http://localhost:8080/price/applied?effectiveDate=2020-06-14+10:00:00&productId=35455&brandId=1


### Tests
In order to run the tests, you have to execute the following command line:

``` 
./gradlew test
```

### Further Improvements
There are a lot of things that can be applied to this API in order to increase scalability and maintenance. Some of them are:
* Instrumentation (better logs)
* Exception handling with *ControllerAdvice*, and get back appropriate errors to the client
* Unit tests with _Mocks_
* Improve the input validation layer
* Some design patterns for choosing a product when more than one strategy is present (like selecting the product with the highest priority, etc...)
* And so on...
