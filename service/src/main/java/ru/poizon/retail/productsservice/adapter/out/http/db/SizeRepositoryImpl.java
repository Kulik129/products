package ru.poizon.retail.productsservice.adapter.out.http.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc.SizeR2dbcRepository;
import ru.poizon.retail.productsservice.domain.model.Size;
import ru.poizon.retail.productsservice.domain.repository.SizeRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SizeRepositoryImpl implements SizeRepository {

    private final SizeR2dbcRepository repository;

    @Override
    public Mono<List<Size>> getSizes(String productId) {
        return repository.findAllByProductId(productId)
                .map(it -> Size.builder()
                        .id(it.getId())
                        .sizeUS(it.getSizeUS())
                        .sizeRU(it.getSizeRU())
                        .length(it.getLength())
                        .build())
                .collectList();
    }
}
