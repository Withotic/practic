package com.example.demo.service;

import com.example.demo.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

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
}
