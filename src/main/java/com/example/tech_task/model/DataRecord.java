package com.example.tech_task.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class DataRecord {
    private UUID id;
    private int type;
    private String randomText;
    private LocalDateTime createdAt;
}
