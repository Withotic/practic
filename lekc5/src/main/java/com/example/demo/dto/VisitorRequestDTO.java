package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class VisitorRequestDTO {
    private String name;
    @Schema(description = "age", example = "25")
    private int age;
    private int isFemale;

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int isFemale() {
        return isFemale;
    }

    public void setFemale(int isFemale) {
        this.isFemale = isFemale;
    }
}
