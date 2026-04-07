package com.example.tech_task.service;

import com.example.tech_task.dto.request.DataRecordRequest;
import com.example.tech_task.model.DataRecord;
import com.example.tech_task.repository.DataRecordRepository;
import com.example.tech_task.routing.DataSourceRouter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.sql.DataSource;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DataRecordServiceTest {

    @Mock
    private DataSourceRouter dataSourceRouter;

    @Mock
    private DataRecordRepository dataRecordRepository;

    @InjectMocks
    private DataServiceImpl service;

    @Test
    @DisplayName("Тест - корректность сохранения бизнес-логики")
    void save_callsRepositoryWithCorrectData(){
        DataRecordRequest request = new DataRecordRequest();
        request.setType(1);
        request.setRandomText("Hello World");

        DataSource mockDs = mock(DataSource.class);
        when(dataSourceRouter.resolve(1)).thenReturn(mockDs);

        service.save(request);

        verify(dataRecordRepository).save(any(DataRecord.class), eq(mockDs));
    }
}
