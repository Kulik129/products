package ru.poizon.retail.productsservice.domain.repository;


import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.domain.model.Size;

import java.util.List;

public interface SizeRepository {

    Mono<List<Size>> getSizes(String productId);
}
