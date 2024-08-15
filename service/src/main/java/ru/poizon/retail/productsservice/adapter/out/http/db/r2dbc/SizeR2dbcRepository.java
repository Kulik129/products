package ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.poizon.retail.productsservice.adapter.out.http.db.entity.SizeEntity;


@Repository
public interface SizeR2dbcRepository extends R2dbcRepository<SizeEntity, String> {
    @Query("SELECT size.id, size.size_us, size.size_ru, size.length, size.product_id FROM size WHERE size.product_id = :productId")
    Flux<SizeEntity> findAllByProductId(String productId);
}
