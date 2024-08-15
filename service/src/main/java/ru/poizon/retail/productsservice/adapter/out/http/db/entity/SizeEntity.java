package ru.poizon.retail.productsservice.adapter.out.http.db.entity;

import org.springframework.data.annotation.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "size")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SizeEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("size_us")
    private String sizeUS;

    @Column("size_ru")
    private String sizeRU;

    @Column("length")
    private String length;

    @Column("product_id")
    private String productId;
}
