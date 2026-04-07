package com.example.tech_task.repository;

import com.example.tech_task.model.DataRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DataRecordRepository {

    public void save(DataRecord record, DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(
                "INSERT INTO data_records(type, random_text) VALUES(?, ?)",
                record.getType(), record.getRandomText()
        );
    }
}
