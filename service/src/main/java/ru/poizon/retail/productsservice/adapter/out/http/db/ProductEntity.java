package ru.poizon.retail.productsservice.adapter.out.http.db;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.poizon.retail.productsservice.domain.model.Media;
import ru.poizon.retail.productsservice.domain.model.Size;

import java.util.List;

@Table(name = "product")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductEntity {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private Long price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "color")
    private String color;

    @Column(name = "old_price")
    private Long oldPrice;

    @Transient
    private List<MediaEntity> media;
    @Transient
    private List<SizeEntity> sizes;
}
