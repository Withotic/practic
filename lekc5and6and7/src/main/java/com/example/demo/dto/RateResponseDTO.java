package com.example.demo.dto;

public class RateResponseDTO {
    private long visitorId;
    private long restaurantId;
    private int rate;
    private String text;

    public RateResponseDTO(long visitorId, long restaurantId, int rate, String text) {
        this.visitorId = visitorId;
        this.restaurantId = restaurantId;
        this.rate = rate;
        this.text = text;
    }

    public long getVisitorId() { return visitorId; }
    public long getRestaurantId() { return restaurantId; }
    public int getRate() { return rate; }
    public String getText() { return text; }
}