package ru.poizon.retail.productsservice.adapter.in.http;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.poizon.retail.products.api.adapter.in.http.ProductApi;
import ru.poizon.retail.productsapi.adapter.in.http.model.GetAllProductsResponseHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.GetProductResponseHttp;
import ru.poizon.retail.productsservice.application.ProductUseCase;

@Api(tags = "Product")
@RestController
@RequiredArgsConstructor
public class ProductHttpApi implements ProductApi {

    private final ProductUseCase productUseCase;

    @Override
    public Mono<GetAllProductsResponseHttp> getAllProducts(ServerWebExchange exchange) {

        return productUseCase.getAllProducts()
                .map(products -> GetAllProductsResponseHttp.builder().payload(products).build());
    }

    @Override
    public Mono<GetProductResponseHttp> getProductById(String id, ServerWebExchange exchange) {
        return productUseCase.getProduct(id)
                .map(product -> GetProductResponseHttp.builder().payload(product).build());
    }
}