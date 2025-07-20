package com.example.demo.controller;

import com.example.demo.dto.RestauRequestDTO;
import com.example.demo.dto.RestauResponseDTO;
import com.example.demo.ResType;
import com.example.demo.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestauController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestaurantService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAll() throws Exception {
        RestauResponseDTO dto = new RestauResponseDTO(0l, "тест", "описание", ResType.European, 25.0, BigDecimal.ONE);
        when(service.getAllAsDTO()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("тест"));
    }

    @Test
    void testPost() throws Exception {
        RestauRequestDTO req = new RestauRequestDTO("кафе", null, ResType.European, 15.0);
        RestauResponseDTO resp = new RestauResponseDTO(0, "кафе", null, ResType.European, 15.0, BigDecimal.ZERO);

        when(service.createFromDTO(any(RestauRequestDTO.class))).thenReturn(resp);

        mockMvc.perform(post("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("кафе"));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/restaurants/1"))
                .andExpect(status().isOk());
    }
}
