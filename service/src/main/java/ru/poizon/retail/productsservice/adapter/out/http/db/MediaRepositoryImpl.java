package ru.poizon.retail.productsservice.adapter.out.http.db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc.MediaR2dbcRepository;
import ru.poizon.retail.productsservice.domain.model.Media;
import ru.poizon.retail.productsservice.domain.repository.MediaRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MediaRepositoryImpl implements MediaRepository {

    private final MediaR2dbcRepository repository;

    @Override
    public Mono<List<Media>> getMedia(String productId) {
        return repository.findByProductId(productId)
                .map(it -> Media.builder()
                        .url(it.getUrl())
                        .build())
                .collectList();
    }
}

