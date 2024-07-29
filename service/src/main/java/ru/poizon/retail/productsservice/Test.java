package ru.poizon.retail.productsservice;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.poizon.retail.products.api.adapter.in.http.PickupPointApi;
import ru.poizon.retail.productsapi.adapter.in.http.model.GetAllStocksResponseHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.MediaHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.PayloadHttp;
import ru.poizon.retail.productsapi.adapter.in.http.model.SizeHttp;

import java.util.List;

@Api(tags = "PickupPoint")
@RestController
@RequiredArgsConstructor
public class Test implements PickupPointApi {

    @Override
    public Mono<GetAllStocksResponseHttp> getPickupPoints(ServerWebExchange exchange) {
        var media1 = MediaHttp.builder().link("https://cdn-img.poizonapp.com/pro-img/cut-img/20230801/d0686833ede446318e6a7809ac2b308d.jpg?x-oss-process=image/format,webp/resize,w_800").build();
        var media2 = MediaHttp.builder().link("https://cdn-img.poizonapp.com/pro-img/cut-img/20230801/d0d0a36169874e37b827c23547719b52.jpg?x-oss-process=image/format,webp/resize,w_800").build();
        var media3 = MediaHttp.builder().link("https://cdn-img.poizonapp.com/pro-img/cut-img/20230801/321c432e18584495a14aaed5f443591f.jpg?x-oss-process=image/format,webp/resize,w_800").build();
        List<MediaHttp> media = List.of(media1, media2, media3);

        SizeHttp size1 = SizeHttp.builder().sizeRU("42.5").sizeUS("6.5").length("24.5").build();
        SizeHttp size2 = SizeHttp.builder().sizeRU("40").sizeUS("5.5").length("22").build();
        SizeHttp size3 = SizeHttp.builder().sizeRU("45").sizeUS("8").length("36").build();
        List<SizeHttp> sizeList = List.of(size1, size2, size3);
        var payload = PayloadHttp.builder()
                .productId("1232hdhd-74737-hdb56-hdb57gb")
                .name("Nike")
                .availability(false)
                .brand("Nike")
                .color("Black")
                .oldPrice(12990L)
                .price(11990L)
                .description("Nike Air Monarch IV 4E \"Whitw/Metallic Silver\" Sneakers")
                .media(media)
                .size(sizeList)
                .build();
        return Mono.just(GetAllStocksResponseHttp.builder()
                        .payload(payload)
                .build());
    }
}
