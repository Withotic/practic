package com.example.demo.controller;

import com.example.demo.dto.VisitorRequestDTO;
import com.example.demo.dto.VisitorResponseDTO;
import com.example.demo.service.VisitorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Получить всех посетителей")
    public List<VisitorResponseDTO> getAll() {
        return service.getAllAsDTO();
    }

    @PostMapping
    @Operation(summary = "Создать нового посетителя")
    @ApiResponse(responseCode = "200", description = "Посетитель успешно создан")
    public VisitorResponseDTO create(@RequestBody VisitorRequestDTO dto) {
        return service.create(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Частично обновить посетителя (необновляемые поля: -1 для чисел и null для строк)")
    @ApiResponse(responseCode = "200", description = "Посетитель успешно обновлён")
    public VisitorResponseDTO patch(@PathVariable long id, @RequestBody VisitorRequestDTO dto) {
        return service.patch(id, dto);
    }
}