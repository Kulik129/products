package ru.poizon.retail.productsservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsapi.adapter.in.http.model.PayloadHttp;
import ru.poizon.retail.productsservice.adapter.out.http.db.converter.MapperData;
import ru.poizon.retail.productsservice.domain.model.Media;
import ru.poizon.retail.productsservice.domain.model.Size;
import ru.poizon.retail.productsservice.domain.repository.MediaRepository;
import ru.poizon.retail.productsservice.domain.repository.ProductRepository;
import ru.poizon.retail.productsservice.domain.repository.SizeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final MediaRepository mediaRepository;
    private final MapperData mapperData;

    public Mono<List<PayloadHttp>> getAllProducts() {
        return productRepository.findAllProducts()
                .flatMapMany(Flux::fromIterable)
                .flatMap(product ->
                        Mono.zip(
                                sizeRepository.getSizes(product.getProductId()),
                                mediaRepository.getMedia(product.getProductId())
                        ).map(tuple -> {
                            List<Size> sizes = tuple.getT1();
                            List<Media> media = tuple.getT2();

                            return mapperData.map(product, sizes, media);
                        })
                )
                .collectList();
    }
}
