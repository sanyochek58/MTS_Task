package com.example.tech_task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DataSourceConfig {

    @Bean
    public List<DataSource> dataSources(DataSourceProperties props) {
        return props.getDatasources().stream().map(
                entry -> (DataSource) DataSourceBuilder.create()
                        .url(entry.getUrl())
                        .username(entry.getUsername())
                        .password(entry.getPassword())
                        .build()
        ).toList();
    }
}
