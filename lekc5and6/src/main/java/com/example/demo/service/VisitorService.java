package com.example.demo.service;

import com.example.demo.Visitor;
import com.example.demo.dto.VisitorRequestDTO;
import com.example.demo.dto.VisitorResponseDTO;
import com.example.demo.repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {
    private final VisitorRepository repository;
    private long count=0;
    public VisitorService(VisitorRepository repository) {
        this.repository = repository;
    }

    public void save(String name, byte age, boolean isFemale) {

        repository.save(new Visitor(count++,name, age, isFemale));
    }

    public void save(byte age, boolean isFemale) {
        repository.save(new Visitor(count++, age, isFemale));
    }

    public void remove(Visitor visitor) {
        repository.remove(visitor);
    }

    public List<Visitor> findAll() {
        return repository.findAll();
    }
    public List<VisitorResponseDTO> getAllAsDTO() {
        return repository.findAll().stream()
            .map(v -> new VisitorResponseDTO(v.getId(), v.getName(), v.getAge(), v.isFemale()))
            .toList();
    }

    public VisitorResponseDTO create(VisitorRequestDTO dto) {
        Visitor visitor = new Visitor(count++, dto.getName(), (byte)dto.getAge(), dto.isFemale()==1);
        repository.save(visitor);
        return new VisitorResponseDTO(visitor.getId(), visitor.getName(), visitor.getAge(), visitor.isFemale());
    }

    public VisitorResponseDTO patch(long id, VisitorRequestDTO dto) {
        List<Visitor> all = repository.findAll();
        for (Visitor visitor : all) {
            if (visitor.getId() == id) {
                // применим обновления вручную
                if (dto.getName() != null)
                    visitor.setName(dto.getName());
                if (dto.getAge() != -1)
                    visitor.setAge((byte)dto.getAge());
                if (dto.isFemale() != -1)
                    visitor.setFemale(dto.isFemale()==1);
                return new VisitorResponseDTO(visitor.getId(), visitor.getName(), visitor.getAge(), visitor.isFemale());
            }
        }

        throw new RuntimeException("Visitor not found");
    }
    public void deleteById(long id) {
        List<Visitor> all = repository.findAll();
        all.removeIf(v -> v.getId() == id);
    }
}
