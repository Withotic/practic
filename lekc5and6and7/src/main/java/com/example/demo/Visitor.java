package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name="Anonymous";
    private byte age;
    private boolean isFemale;
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
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(byte age) {
        this.age = age;
    }
    public void setFemale(boolean isFemale) {
        this.isFemale = isFemale;
    }
    public Visitor() {}
    public Visitor(long id,String name, byte age, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
        this.id=id;
    }
    public Visitor(long id,byte age, boolean isFemale) {
        this.age = age;
        this.isFemale = isFemale;
        this.id=id;
    }
}
