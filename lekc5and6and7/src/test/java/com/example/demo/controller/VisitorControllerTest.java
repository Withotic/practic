package com.example.demo.controller;

import com.example.demo.dto.VisitorRequestDTO;
import com.example.demo.dto.VisitorResponseDTO;
import com.example.demo.service.VisitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VisitorController.class)
public class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitorService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllVisitors() throws Exception {
        VisitorResponseDTO dto = new VisitorResponseDTO(1L, "Test", (byte) 20, true);
        when(service.getAllAsDTO()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/visitors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test"));
    }

    @Test
    void testPostVisitor() throws Exception {
        VisitorRequestDTO req = new VisitorRequestDTO("Anna", 22, true);
        VisitorResponseDTO resp = new VisitorResponseDTO(1L, "Anna", (byte) 22, true);

         when(service.create(any(VisitorRequestDTO.class))).thenReturn(resp);

        mockMvc.perform(post("/api/visitors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Anna"));
    }

    @Test
    void testDeleteVisitor() throws Exception {
        mockMvc.perform(delete("/api/visitors/1"))
                .andExpect(status().isOk());
    }
}
