package com.example.tech_task.controller;

import com.example.tech_task.dto.request.DataRecordRequest;
import com.example.tech_task.model.DataRecord;
import com.example.tech_task.service.DataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DataRecordController {

    private final DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<?> createDataRecord(@Valid @RequestBody DataRecordRequest request){
        dataService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
