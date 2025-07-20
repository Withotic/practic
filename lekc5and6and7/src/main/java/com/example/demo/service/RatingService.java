package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Rating;
import com.example.demo.Restaurant;
import com.example.demo.dto.RateRequestDTO;
import com.example.demo.dto.RateResponseDTO;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.VisitorRepository;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final VisitorRepository visitorRepository;
    private final RestaurantRepository restaurantRepository;

    public RatingService(RatingRepository ratingRepository,VisitorRepository visitorRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.visitorRepository = visitorRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void save(Rating rating) {
        ratingRepository.save(rating);
        recalculateRestaurantRating(rating.getIdR());
    }


    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(long id) {
        return ratingRepository.findById(id);
    }

    private void recalculateRestaurantRating(long restaurantId) {
        Optional<Restaurant> restOpt = restaurantRepository.findById(restaurantId);
        if (restOpt.isEmpty()) return;

        Restaurant restaurant = restOpt.get();

        List<Rating> ratings = ratingRepository.findAll().stream()
                .filter(r -> r.getIdR() == restaurantId)
                .toList();

        if (ratings.isEmpty()) {
            restaurant.setRate(BigDecimal.ZERO);
        } else {
            int sum = ratings.stream().mapToInt(Rating::getRate).sum();
            BigDecimal average = BigDecimal.valueOf(sum)
                    .divide(BigDecimal.valueOf(ratings.size()), 2, RoundingMode.HALF_UP);
            restaurant.setRate(average);
        }

        restaurantRepository.save(restaurant);
    }
    public List<RateResponseDTO> getAllAsDTO() {
        return ratingRepository.findAll().stream()
            .map(r -> new RateResponseDTO(r.getIdV(), r.getIdR(), r.getRate(), r.getText()))
            .toList();
    }

    public RateResponseDTO createFromDTO(RateRequestDTO dto) {
        if (!visitorRepository.existsById(dto.getVisitorId()))
            throw new RuntimeException("Посетитель не найден");

        if (!restaurantRepository.existsById(dto.getRestaurantId()))
            throw new RuntimeException("Ресторан не найден");

        Rating rating = new Rating(dto.getVisitorId(), dto.getRestaurantId(), dto.getRate(), dto.getText());
        ratingRepository.save(rating);
        recalculateRestaurantRating(dto.getRestaurantId());
        return new RateResponseDTO(rating.getIdV(), rating.getIdR(), rating.getRate(), rating.getText());
    }


    public RateResponseDTO patchRating(long visitorId, long restaurantId, RateRequestDTO dto) {
        Optional<Rating> opt = ratingRepository.findAll().stream()
                .filter(r -> r.getIdV() == visitorId && r.getIdR() == restaurantId)
                .findFirst();

        if (opt.isEmpty())
            throw new RuntimeException("Оценка не найдена");

        Rating rating = opt.get();

        if (dto.getRate() != 0) rating.setRate(dto.getRate());
        if (dto.getText() != null) rating.setText(dto.getText());

        ratingRepository.save(rating);
        recalculateRestaurantRating(restaurantId);

        return new RateResponseDTO(rating.getIdV(), rating.getIdR(), rating.getRate(), rating.getText());
    }
    public void deleteByIds(long visitorId, long restaurantId) {
        Optional<Rating> found = ratingRepository.findAll().stream()
                .filter(r -> r.getIdV() == visitorId && r.getIdR() == restaurantId)
                .findFirst();

        found.ifPresent(rating -> {
            ratingRepository.delete(rating);
            recalculateRestaurantRating(rating.getIdR());
        });
    }
}
