package com.example.demo.repository;

import com.example.demo.Visitor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VisitorRepository {
    private final List<Visitor> visitors = new ArrayList<>();

    public void save(Visitor visitor) {
        visitors.add(new Visitor(visitor.getName(), visitor.getAge(), visitor.isFemale()));
    }

    public void remove(Visitor visitor) {
        visitors.remove(visitor);
    }

    public List<Visitor> findAll() {
        return new ArrayList<>(visitors);
    }
}