package ru.poizon.retail.productsservice.adapter.out.http.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "size")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MediaEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("url")
    private String url;

    @Column("product_id")
    private String productId;
}
