package ru.poizon.retail.productsservice;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.poizon.retail.products.api.adapter.in.http.PickupPointApi;
import ru.poizon.retail.productsapi.adapter.in.http.model.GetAllPickupPointsResponseHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.GetAllPickupPointsResponsePayloadHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.PickupPointShortInfoHttp;

import java.util.List;

@Api(tags = "PickupPoint")
@RestController
@RequiredArgsConstructor
public class Test implements PickupPointApi {

    @Override
    public Mono<GetAllPickupPointsResponseHttp> getPickupPoints(ServerWebExchange exchange) {
        PickupPointShortInfoHttp pickupPointShortInfoHttp = PickupPointShortInfoHttp.builder().name("hello").build();
        List<PickupPointShortInfoHttp> list = List.of(pickupPointShortInfoHttp);
        return Mono.just(GetAllPickupPointsResponseHttp.builder()
                .payload(GetAllPickupPointsResponsePayloadHttp
                        .builder().content(list).build()).build());
    }
}
