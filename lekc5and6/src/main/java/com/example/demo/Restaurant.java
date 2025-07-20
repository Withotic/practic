package com.example.demo;

import java.math.BigDecimal;
public class Restaurant {
    private long id;
    private String name;
    private String desc="";
    private ResType type;
    private double AvgCheq;
    private BigDecimal rate;
    private int rateCount;
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }
    public ResType getType() {
        return type;
    }
    public double getAvgCheq() {
        return AvgCheq;
    }
    public BigDecimal getRate() {
        return rate;
    }
    public void setRate(BigDecimal rate){
        this.rate=rate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setType(ResType type) {
        this.type = type;
    }
    public void setAvgCheq(double avgCheq) {
        AvgCheq = avgCheq;
    }
    public int getRateCount() {
        return rateCount;
    }
    public Restaurant(long id,String name, String desc, ResType type, double avgCheq, BigDecimal rate) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        AvgCheq = avgCheq;
        this.rate = rate;
        this.id=id;
    }
    public Restaurant(long id,String name, ResType type, double avgCheq, BigDecimal rate) {
        this.name = name;
        this.type = type;
        AvgCheq = avgCheq;
        this.rate = rate;
        this.id=id;
    }
    @Override
    public String toString() {
        return "Название: " + name +
                    ", Тип: " + type +
                    ", Средний чек: " + AvgCheq +
                    ", Оценка: " + rate;
    }
}