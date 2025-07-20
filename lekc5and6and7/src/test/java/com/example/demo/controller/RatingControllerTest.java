package com.example.demo.controller;

import com.example.demo.dto.RateRequestDTO;
import com.example.demo.dto.RateResponseDTO;
import com.example.demo.service.RatingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RateController.class)
public class RatingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RatingService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAll() throws Exception {
        RateResponseDTO dto = new RateResponseDTO(0, 0, 5, "хорошо покушал");
        when(service.getAllAsDTO()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/reviews"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].rate").value(5));
    }

    @Test
    void testPost() throws Exception {
        RateRequestDTO req = new RateRequestDTO(1, 1, 4, "норм");
        RateResponseDTO resp = new RateResponseDTO(1, 1, 4, "норм");

        when(service.createFromDTO(any(RateRequestDTO.class))).thenReturn(resp);

        mockMvc.perform(post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rate").value(4));
    }
}
