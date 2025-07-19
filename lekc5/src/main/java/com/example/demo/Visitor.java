package com.example.demo;
public class Visitor {
    static long cid=0;
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
    public Visitor(String name, byte age, boolean isFemale) {
        this.name = name;
        this.age = age;
        this.isFemale = isFemale;
        id=cid++;
    }
    public Visitor(byte age, boolean isFemale) {
        this.age = age;
        this.isFemale = isFemale;
        id=cid++;
    }
}
