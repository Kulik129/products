package ru.poizon.retail.productsservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Size {
    private Long id;
    private String sizeUS;
    private String sizeRU;
    private String length;
}
