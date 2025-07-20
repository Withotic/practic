package com.example.demo.service;

import com.example.demo.Visitor;
import com.example.demo.repository.VisitorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VisitorServiceTest {

    @Mock
    private VisitorRepository repository;

    @InjectMocks
    private VisitorService service;

    public VisitorServiceTest() {
        MockitoAnnotations.openMocks(this); // инициализация моков
    }

    @Test
    void testFindAll() {
        Visitor v = new Visitor(0,"Алина", (byte) 30, true);
        when(repository.findAll()).thenReturn(List.of(v));

        List<Visitor> result = service.findAll();

        assertEquals(1, result.size());
        assertEquals("Алина", result.get(0).getName());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Visitor v = new Visitor(0,"Иван", (byte) 25, false);
        when(repository.findById(1L)).thenReturn(Optional.of(v));

        Optional<Visitor> result = service.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Иван", result.get().getName());
    }

    @Test
    void testSave() {
        Visitor v = new Visitor(0,"Женя", (byte) 20, true);
        when(repository.save(v)).thenReturn(v);

        Visitor saved = service.save(v);
        assertEquals("Женя", saved.getName());
        verify(repository).save(v);
    }

    @Test
    void testDeleteById() {
        service.deleteById(42L);
        verify(repository, times(1)).deleteById(42L);
    }
}
