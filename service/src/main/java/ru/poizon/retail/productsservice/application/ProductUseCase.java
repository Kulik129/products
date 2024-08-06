package ru.poizon.retail.productsservice.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.poizon.retail.productsapi.adapter.in.http.model.PayloadHttp;
import ru.poizon.retail.productsservice.domain.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;

    public Mono<List<PayloadHttp>> getAllProducts() {
        return productRepository.findAllProducts()
                .map(products -> products.stream()
                        .map(pr -> PayloadHttp.builder()
                                .productId(pr.getProductId())
                                .name(pr.getName())
                                .price(pr.getPrice())
                                .color(pr.getColor())
                                .brand(pr.getBrand())
                                .description(pr.getDescription())
                                .availability(pr.getAvailability())
                                .oldPrice(pr.getOldPrice())
                                .price(pr.getPrice())
                                .build())
                        .toList());
    }
}
