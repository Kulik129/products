package ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import ru.poizon.retail.productsservice.adapter.out.http.db.entity.MediaEntity;

public interface MediaR2dbcRepository extends R2dbcRepository<MediaEntity, Integer> {
    @Query("SELECT media.id, media.url, media.product_id FROM media WHERE media.product_id = :productId")
    Flux<MediaEntity> findByProductId(String productId);
}
