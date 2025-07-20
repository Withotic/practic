package com.example.demo.service;

import com.example.demo.Restaurant;
import com.example.demo.ResType;
import com.example.demo.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository repository;

    @InjectMocks
    private RestaurantService service;

    public RestaurantServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Restaurant r = new Restaurant(0,"peperoni porfavore", "Итальянская кухня", ResType.Italian, 25.0, BigDecimal.ZERO);
        when(repository.findAll()).thenReturn(List.of(r));

        List<Restaurant> all = service.findAll();
        assertEquals(1, all.size());
        assertEquals("peperoni porfavore", all.get(0).getName());
    }

    @Test
    void testDeleteById() {
        service.deleteById(0);
        verify(repository).deleteById(0l);
    }

    @Test
    void testSave() {
        Restaurant r = new Restaurant(1,"терияки", ResType.Chinese, 18.5, BigDecimal.ZERO);
        when(repository.save(r)).thenReturn(r);

        Restaurant saved = service.save(r);
        assertEquals("терияки", saved.getName());
    }
}
