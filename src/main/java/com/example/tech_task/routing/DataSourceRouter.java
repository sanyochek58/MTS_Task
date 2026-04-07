package com.example.tech_task.routing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSourceRouter {

    private final List<DataSource> dataSources;

    public DataSource resolve(Integer type){
        int index = type % dataSources.size();
        return dataSources.get(index);
    }
}
