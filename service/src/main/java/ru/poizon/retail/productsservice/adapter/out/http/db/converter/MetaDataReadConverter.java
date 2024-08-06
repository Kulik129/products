package ru.poizon.retail.productsservice.adapter.out.http.db.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;
import java.util.Map;

@Slf4j
@ReadingConverter
@RequiredArgsConstructor
@SuppressWarnings("MissingJavadocType")
public class MetaDataReadConverter implements Converter<Json, Map<String, Object>> {

    private static final TypeReference<Map<String, Object>> TYPE_REF = new TypeReference<>() {};
    private final ObjectMapper objectMapper;

    @Override
    public Map<String, Object> convert(Json json) {
        try {
            return objectMapper.readValue(json.asString(), TYPE_REF);
        } catch (IOException e) {
            log.error("Problem while parsing JSON: {}", json, e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
