package com.example.tech_task.router;

import com.example.tech_task.exception.InvalidTypeException;
import com.example.tech_task.routing.DataSourceRouter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class DataRecordRouteTest {

    private DataSourceRouter router;

    @BeforeEach
    public void init() {
        List<DataSource> dataSources = List.of(
                mock(DataSource.class),
                mock(DataSource.class),
                mock(DataSource.class)
        );

        router = new DataSourceRouter(dataSources);
    }

    @Test
    @DisplayName("Тест сохранение значение в БД1")
    public void saveDataRecordTest1() throws Exception {
        DataSource result = router.resolve(0);
        assertNotNull(result);
    }

    @Test
    void resolve_negativeType_throwsException() {
        assertThrows(InvalidTypeException.class, () -> router.resolve(-1));
    }
}
