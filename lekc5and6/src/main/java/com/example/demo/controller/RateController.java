package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RateRequestDTO;
import com.example.demo.dto.RateResponseDTO;
import com.example.demo.service.RatingService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/reviews")
public class RateController {

    private final RatingService service;

    public RateController(RatingService service) {
        this.service = service;
    }

    @GetMapping
    public List<RateResponseDTO> getAll() {
        return service.getAllAsDTO();
    }

    @PostMapping
    public RateResponseDTO create(@RequestBody RateRequestDTO dto) {
        return service.createFromDTO(dto);
    }
    @PatchMapping
    @Operation(summary = "Частично обновить отзыв по ID посетителя и ресторана")
    public RateResponseDTO patch(@RequestParam long visitorId,
                                @RequestParam long restaurantId,
                                @RequestBody RateRequestDTO dto) {
        return service.patchRating(visitorId, restaurantId, dto);
    }
}
