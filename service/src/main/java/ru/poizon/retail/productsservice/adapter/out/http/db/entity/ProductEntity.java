package ru.poizon.retail.productsservice.adapter.out.http.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "product")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductEntity {

    @Id
    @Column("product_id")
    private String productId;

    @Column("price")
    private Long price;

    @Column("brand")
    private String brand;

    @Column("description")
    private String description;

    @Column("name")
    private String name;

    @Column("availability")
    private Boolean availability;

    @Column("color")
    private String color;

    @Column("old_price")
    private Long oldPrice;

    @Transient
    private List<MediaEntity> media;
    @Transient
    private List<SizeEntity> sizes;
}
