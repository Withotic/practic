package com.example.demo.service;

import com.example.demo.Rating;
import com.example.demo.Restaurant;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RestaurantRepository restaurantRepository;

    public RatingService(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void save(Rating rating) {
        ratingRepository.save(rating);
        recalculateRestaurantRating(rating.getIdR());
    }

    public void remove(Rating rating) {
        ratingRepository.remove(rating);
        recalculateRestaurantRating(rating.getIdR());
    }

    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(long idV, long idR) {
        return ratingRepository.findById(idV, idR);
    }

    private void recalculateRestaurantRating(long restaurantId) {
        List<Rating> allRatings = ratingRepository.findAll();
        List<Restaurant> allRestaurants = restaurantRepository.findAll();

        for (Restaurant restaurant : allRestaurants) {
            if (restaurant.getId() == restaurantId) {
                long count = 0;
                int sum = 0;
                for (Rating r : allRatings) {
                    if (r.getIdR() == restaurantId) {
                        sum += r.getRate();
                        count++;
                    }
                }
                if (count > 0)
                    restaurant.setRate(BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP));
                break;
            }
        }
    }
}
