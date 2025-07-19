package com.example.demo.repository;

import com.example.demo.Rating;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RatingRepository {
    private final List<Rating> ratings = new ArrayList<>();

    public void save(Rating rating) {
        ratings.add(rating);
    }

    public void remove(Rating rating) {
        ratings.remove(rating);
    }

    public List<Rating> findAll() {
        return new ArrayList<>(ratings);
    }

    public Optional<Rating> findById(long idV, long idR) {
        return ratings.stream()
                .filter(r -> r.getIdV() == idV && r.getIdR() == idR)
                .findFirst();
    }
}