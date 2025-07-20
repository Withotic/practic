package com.example.demo.dto;

public class VisitorResponseDTO {
    private long id;
    private String name;
    private byte age;
    private boolean isFemale;

    public VisitorResponseDTO(long id, String name, byte age, boolean isFemale) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
    }

    // геттеры
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public boolean isFemale() {
        return isFemale;
    }
}
