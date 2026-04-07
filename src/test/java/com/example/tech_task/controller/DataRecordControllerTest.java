package com.example.tech_task.controller;

import com.example.tech_task.dto.request.DataRecordRequest;
import com.example.tech_task.exception.GlobalExceptionHandler;
import com.example.tech_task.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DataRecordController.class)
@Import(GlobalExceptionHandler.class)
public class DataRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DataService dataService;

    private DataRecordRequest buildSuccessRequest(){
        DataRecordRequest dataRecordRequest = new DataRecordRequest();
        dataRecordRequest.setType(1);
        dataRecordRequest.setRandomText("Hello World");
        return dataRecordRequest;
    };

    private DataRecordRequest buildFailRequestType(){
        DataRecordRequest dataRecordRequest = new DataRecordRequest();
        dataRecordRequest.setType(-1);
        dataRecordRequest.setRandomText("Hello World");
        return dataRecordRequest;
    }

    private DataRecordRequest buildFailRequestBlankText(){
        DataRecordRequest dataRecordRequest = new DataRecordRequest();
        dataRecordRequest.setType(0);
        dataRecordRequest.setRandomText("");
        return dataRecordRequest;
    }

    @Test
    @DisplayName("Отправка данных на сервер успешна ! - статус код 200")
    public void saveDataRecordTest() throws Exception {
        mockMvc.perform(post("/api/data").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(buildSuccessRequest())))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Отправка данных на сервер с ошибкой ! - Невалидный type - статус код 400")
    public void saveDataRecordFailTest() throws Exception {
        mockMvc.perform(post("/api/data").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(buildFailRequestType()))).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Отправка данных на сервер с ошибкой ! -  Пустой random_text - статус код 400")
    public void saveDataRecordFailTest2() throws Exception {
        mockMvc.perform(post("/api/data").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(buildFailRequestBlankText()))).andExpect(status().isBadRequest());
    }

}
