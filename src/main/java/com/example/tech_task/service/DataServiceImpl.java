package com.example.tech_task.service;

import com.example.tech_task.dto.request.DataRecordRequest;
import com.example.tech_task.model.DataRecord;
import com.example.tech_task.repository.DataRecordRepository;
import com.example.tech_task.routing.DataSourceRouter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRecordRepository dataRecordRepository;
    private final DataSourceRouter router;

    @Override
    public void save(DataRecordRequest request){
        DataSource db = router.resolve(request.getType());

        DataRecord dataRecord = new DataRecord();
        dataRecord.setType(request.getType());
        dataRecord.setRandomText(request.getRandomText());

        dataRecordRepository.save(dataRecord, db);
    }
}
