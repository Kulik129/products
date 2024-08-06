package ru.poizon.retail.productsservice.domain.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.domain.model.Product;


public interface ProductRepository {

    Mono<Product> findById(String id);

    Flux<Product> findAllProducts();
}
