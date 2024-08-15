package ru.poizon.retail.productsservice.adapter.out.http.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc.ProductR2dbcRepository;
import ru.poizon.retail.productsservice.domain.model.Product;
import ru.poizon.retail.productsservice.domain.repository.ProductRepository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductR2dbcRepository repository;

    @Override
    public Mono<List<Product>> findAllProducts() {
        return repository.findAll()
                .map(product -> Product.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .brand(product.getBrand())
                        .description(product.getDescription())
                        .color(product.getColor())
                        .availability(product.getAvailability())
                        .oldPrice(product.getOldPrice())
                        .build())
                .collectList();
    }
}
