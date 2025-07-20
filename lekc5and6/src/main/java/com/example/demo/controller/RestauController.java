package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestauRequestDTO;
import com.example.demo.dto.RestauResponseDTO;
import com.example.demo.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/restaurants")
public class RestauController {

    private final RestaurantService service;

    public RestauController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    public List<RestauResponseDTO> getAll() {
        return service.getAllAsDTO();
    }

    @PostMapping
    public RestauResponseDTO create(@RequestBody RestauRequestDTO dto) {
        return service.createFromDTO(dto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Частично обновить ресторан")
    public RestauResponseDTO patch(@PathVariable long id,
                                    @RequestBody RestauRequestDTO dto) {
        return service.patchRestaurant(id, dto);
    }
}
