package com.example.demo;

import java.math.BigDecimal;
public class Restaurant {
    private static long cid=0;
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
    public int getRateCount() {
        return rateCount;
    }
    public Restaurant(String name, String desc, ResType type, double avgCheq, BigDecimal rate) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        AvgCheq = avgCheq;
        this.rate = rate;
        id=cid++;
    }
    public Restaurant(String name, ResType type, double avgCheq, BigDecimal rate) {
        this.name = name;
        this.type = type;
        AvgCheq = avgCheq;
        this.rate = rate;
        id=cid++;
    }
    @Override
    public String toString() {
        return "Название: " + name +
                    ", Тип: " + type +
                    ", Средний чек: " + AvgCheq +
                    ", Оценка: " + rate;
    }
}