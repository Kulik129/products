package ru.poizon.retail.productsservice.domain.repository;

import reactor.core.publisher.Mono;
import ru.poizon.retail.productsservice.domain.model.Media;

import java.util.List;

public interface MediaRepository {

    Mono<List<Media>> getMedia(String productId);
}
