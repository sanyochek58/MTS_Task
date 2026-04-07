package com.example.tech_task.routing;

import com.example.tech_task.exception.InvalidTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSourceRouter {

    private final List<DataSource> dataSources;

    public DataSource resolve(Integer type){
        if(type < 0){
            throw new InvalidTypeException("Type не должен быть отрицательным !");
        }
        int index = type % dataSources.size();
        return dataSources.get(index);
    }
}
