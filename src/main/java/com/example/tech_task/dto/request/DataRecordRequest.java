package com.example.tech_task.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DataRecordRequest {

    @NotNull
    @Min(value = 0, message = "type не может быть отрицательным")
    private Integer type;

    @NotBlank
    @Size(min = 1, max = 100)
    private String randomText;

}
