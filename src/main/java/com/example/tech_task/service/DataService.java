package com.example.tech_task.service;

import com.example.tech_task.dto.request.DataRecordRequest;

import javax.sql.DataSource;

public interface DataService {
    void save(DataRecordRequest request);
}
