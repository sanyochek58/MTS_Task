package com.example.tech_task.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "db")
public class DataSourceProperties {

    private List<DataSourceEntry> datasources;

    @Getter
    @Setter
    public static class DataSourceEntry {
        private String url;
        private String username;
        private String password;
    }
}
