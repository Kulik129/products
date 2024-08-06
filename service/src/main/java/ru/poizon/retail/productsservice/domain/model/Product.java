package ru.poizon.retail.productsservice.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Slf4j
public class Product {

    private String productId;
    private Long price;
    private String brand;
    private String description;
    private String name;
    private Boolean availability;
    private String color;
    private Long oldPrice;
    private List<Media> media;
    private List<Size> sizes;
}
