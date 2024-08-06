package ru.poizon.retail.productsservice.domain.repository;

import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.domain.model.Product;

import java.util.List;


public interface ProductRepository {

    Mono<List<Product>> findAllProducts();
}
