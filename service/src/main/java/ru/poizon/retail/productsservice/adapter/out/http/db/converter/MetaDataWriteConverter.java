package ru.poizon.retail.productsservice.adapter.out.http.db.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.util.LinkedHashMap;

@Slf4j
@RequiredArgsConstructor
@WritingConverter
@SuppressWarnings("MissingJavadocType")
public class MetaDataWriteConverter implements Converter<LinkedHashMap<String, Object>, Json> {

    private final ObjectMapper objectMapper;

    @Override
    public Json convert(LinkedHashMap<String, Object> source) {
        try {
            return Json.of(objectMapper.writeValueAsString(source));
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing map to JSON: {}", source, e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
