package com.example.demo.service;

import com.example.demo.Restaurant;
import com.example.demo.dto.RestauRequestDTO;
import com.example.demo.dto.RestauResponseDTO;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;
    private long count=0;
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }
    public List<RestauResponseDTO> getAllAsDTO() {
        return repository.findAll().stream()
            .map(r -> new RestauResponseDTO(r.getId(), r.getName(), r.getDesc(), r.getType(), r.getAvgCheq(), r.getRate()))
            .toList();
    }

    public RestauResponseDTO createFromDTO(RestauRequestDTO dto) {
        Restaurant restaurant = new Restaurant(count++, dto.getName(), dto.getDesc(), dto.getType(), dto.getAvgCheq(), BigDecimal.ZERO);
        repository.save(restaurant);
        return new RestauResponseDTO(restaurant.getId(), restaurant.getName(), restaurant.getDesc(), restaurant.getType(), restaurant.getAvgCheq(), restaurant.getRate());
    }
    public RestauResponseDTO patchRestaurant(long id, RestauRequestDTO dto) {
        Optional<Restaurant> opt = repository.findById(id);
        if (opt.isEmpty()) throw new RuntimeException("Ресторан не найден");

        Restaurant restaurant = opt.get();

        if (dto.getName() != null) restaurant.setName(dto.getName());
        if (dto.getDesc() != null) restaurant.setDesc(dto.getDesc());
        if (dto.getType() != null) restaurant.setType(dto.getType());
        if (dto.getAvgCheq() != -1) restaurant.setAvgCheq(dto.getAvgCheq());

        repository.save(restaurant);

        return new RestauResponseDTO(
                restaurant.getId(), restaurant.getName(),
                restaurant.getDesc(), restaurant.getType(),
                restaurant.getAvgCheq(), restaurant.getRate());
    }
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
