package com.example.demo;

public class TestClass {
    int q;
    public TestClass(int q){
        this.q=q;
        System.out.println("null");
    }
    @Override
    public String toString() {
        return "im q "+q;
    }
}
