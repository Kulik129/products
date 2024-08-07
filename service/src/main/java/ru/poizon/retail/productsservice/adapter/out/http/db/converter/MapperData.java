package ru.poizon.retail.productsservice.adapter.out.http.db.converter;

import org.mapstruct.Mapper;
import ru.poizon.retail.productsapi.adapter.in.http.model.SizeHttp;
import ru.poizon.retail.productsservice.adapter.out.http.db.SizeEntity;
import ru.poizon.retail.productsservice.domain.model.Size;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperData {

    List<Size> map(List<SizeEntity> sizeHttps);

    List<SizeHttp> mapS(List<Size> sizes);
}
