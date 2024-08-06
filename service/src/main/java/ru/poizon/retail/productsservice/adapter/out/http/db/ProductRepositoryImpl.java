package ru.poizon.retail.productsservice.adapter.out.http.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.domain.model.Product;
import ru.poizon.retail.productsservice.domain.repository.ProductRepository;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductR2dbcRepository repository;
    @Override
    public Mono<Product> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Product> findAllProducts() {
        return repository.findAll();
    }
}
