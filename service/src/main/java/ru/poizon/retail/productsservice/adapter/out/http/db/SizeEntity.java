package ru.poizon.retail.productsservice.adapter.out.http.db;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "size")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SizeEntity {
    @Column(name = "size_us")
    private String sizeUS;

    @Column(name = "size_ru")
    private String sizeRU;

    @Column(name = "length")
    private String length;
}
