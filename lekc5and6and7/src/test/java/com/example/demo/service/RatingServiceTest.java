package com.example.demo.service;

import com.example.demo.Rating;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private VisitorRepository visitorRepository;

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RatingService ratingService;

    public RatingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Rating r = new Rating(0, 0, 5, "Красивое место");
        when(ratingRepository.findAll()).thenReturn(List.of(r));

        List<Rating> result = ratingService.findAll();
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).getRate());
    }

    @Test
    void testDeleteRating() {
        Rating r = new Rating(0, 0, 3);
        when(ratingRepository.findAll()).thenReturn(List.of(r));

        ratingService.deleteByIds(0, 0);
        verify(ratingRepository).delete(r);
    }
}
