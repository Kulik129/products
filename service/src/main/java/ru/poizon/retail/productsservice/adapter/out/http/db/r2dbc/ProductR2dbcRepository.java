package ru.poizon.retail.productsservice.adapter.out.http.db.r2dbc;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import ru.poizon.retail.productsservice.adapter.out.http.db.entity.ProductEntity;

@Repository
public interface ProductR2dbcRepository extends R2dbcRepository<ProductEntity, String> {
}
