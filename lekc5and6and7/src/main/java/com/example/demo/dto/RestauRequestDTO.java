package com.example.demo.dto;

import com.example.demo.ResType;

public class RestauRequestDTO {
    private String name;
    private String desc;
    private ResType type;
    private double avgCheq;

    public RestauRequestDTO(String name, String desc, ResType type, double avgCheq) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.avgCheq = avgCheq;
    }
    // геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public ResType getType() { return type; }
    public void setType(ResType type) { this.type = type; }

    public double getAvgCheq() { return avgCheq; }
    public void setAvgCheq(double avgCheq) { this.avgCheq = avgCheq; }
}
