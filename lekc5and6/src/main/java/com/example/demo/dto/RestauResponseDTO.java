package com.example.demo.dto;

import com.example.demo.ResType;

import java.math.BigDecimal;

public class RestauResponseDTO {
    private long id;
    private String name;
    private String desc;
    private ResType type;
    private double avgCheq;
    private BigDecimal rate;

    public RestauResponseDTO(long id, String name, String desc, ResType type, double avgCheq, BigDecimal rate) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.avgCheq = avgCheq;
        this.rate = rate;
    }

    // геттеры
    public long getId() { return id; }
    public String getName() { return name; }
    public String getDesc() { return desc; }
    public ResType getType() { return type; }
    public double getAvgCheq() { return avgCheq; }
    public BigDecimal getRate() { return rate; }
}