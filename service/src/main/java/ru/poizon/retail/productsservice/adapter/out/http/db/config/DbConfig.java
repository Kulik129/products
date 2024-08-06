package ru.poizon.retail.productsservice.adapter.out.http.db.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import ru.poizon.retail.productsservice.adapter.out.http.db.converter.MetaDataReadConverter;
import ru.poizon.retail.productsservice.adapter.out.http.db.converter.MetaDataWriteConverter;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing(dateTimeProviderRef = "lmDateTimeProvider")
class DbConfig {

    /**
     * Для формирования значений полей дат создания/обновления сущностей БД.
     *
     * @param clock - {@link Clock}
     * @return - {@link DateTimeProvider}
     */
    @Bean(name = "lmDateTimeProvider")
    public DateTimeProvider lmDateTimeProvider(Clock clock) {
        return () -> Optional.of(LocalDateTime.now(clock));
    }

    @Bean
    public DataSource jdbcDataSource(
            @Value("${spring.datasource.driver-class-name}") String driver,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String userName,
            @Value("${spring.datasource.password}") String password
    ) {
        return DataSourceBuilder.create()
                .driverClassName(driver)
                .url(url)
                .username(userName)
                .password(password)
                .build();
    }

    @Bean
    public R2dbcCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        var objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        converters.add(new MetaDataReadConverter(objectMapper));
        converters.add(new MetaDataWriteConverter(objectMapper));
        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, converters);
    }
}
