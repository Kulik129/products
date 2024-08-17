package ru.poizon.retail.productsservice.adapter.out.http.db.converter;

import org.mapstruct.Mapper;
import ru.poizon.retail.productsapi.adapter.in.http.model.ArticleHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.MediaHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.PayloadHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.SizeHttp;
import ru.poizon.retail.productsservice.adapter.out.http.db.entity.SizeEntity;
import ru.poizon.retail.productsservice.domain.model.Media;
import ru.poizon.retail.productsservice.domain.model.Product;
import ru.poizon.retail.productsservice.domain.model.Size;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperData {

    List<Size> map(List<SizeEntity> sizeHttps);

    List<SizeHttp> mapSize(List<Size> sizes);

    default List<MediaHttp> mapMedia(List<Media> media) {
        return media.stream()
                .map(it -> MediaHttp.builder()
                        .link(it.getUrl())
                        .build())
                .toList();
    }

    default PayloadHttp map(Product product, List<Size> sizes, List<Media> media) {
        return PayloadHttp.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .color(product.getColor())
                .brand(product.getBrand())
                .description(product.getDescription())
                .availability(product.getAvailability())
                .oldPrice(product.getOldPrice())
                .size(mapSize(sizes))
                .media(mapMedia(media))
                .build();
    }

    default ArticleHttp mapArticle(Product product, List<Size> sizes, List<Media> media) {
        return ArticleHttp.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .price(product.getPrice())
                .color(product.getColor())
                .brand(product.getBrand())
                .description(product.getDescription())
                .availability(product.getAvailability())
                .oldPrice(product.getOldPrice())
                .size(mapSize(sizes))
                .media(mapMedia(media))
                .build();
    }
}
