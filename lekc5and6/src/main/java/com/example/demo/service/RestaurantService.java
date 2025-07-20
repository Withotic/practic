package com.example.demo.service;

import com.example.demo.Restaurant;
import com.example.demo.dto.RestauRequestDTO;
import com.example.demo.dto.RestauResponseDTO;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public void remove(Restaurant restaurant) {
        repository.remove(restaurant);
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
        Restaurant restaurant = new Restaurant(0, dto.getName(), dto.getDesc(), dto.getType(), dto.getAvgCheq(), BigDecimal.ZERO);
        repository.save(restaurant);
        return new RestauResponseDTO(restaurant.getId(), restaurant.getName(), restaurant.getDesc(), restaurant.getType(), restaurant.getAvgCheq(), restaurant.getRate());
    }
    public RestauResponseDTO patchRestaurant(long id, RestauRequestDTO dto) {
        for (Restaurant restaurant : repository.findAll()) {
            if (restaurant.getId() == id) {
                    if (dto.getName() != null)
                        restaurant.setName(dto.getName());
                    if (dto.getDesc() != null) 
                        restaurant.setDesc(dto.getDesc());
                    if (dto.getType() != null)
                        restaurant.setType(dto.getType());
                    if (dto.getAvgCheq() != -1)
                        restaurant.setAvgCheq(dto.getAvgCheq());

                return new RestauResponseDTO(
                        restaurant.getId(), restaurant.getName(),
                        restaurant.getDesc(), restaurant.getType(),
                        restaurant.getAvgCheq(), restaurant.getRate()
                );
            }
        }

        throw new RuntimeException("Ресторан не найден");
    }
    public void deleteById(long id) {
        List<Restaurant> all = repository.findAll();
        all.removeIf(r -> r.getId() == id);
    }
}
