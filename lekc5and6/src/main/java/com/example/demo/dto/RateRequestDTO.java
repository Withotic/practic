package com.example.demo.dto;

public class RateRequestDTO {
    private long visitorId;
    private long restaurantId;
    private int rate;
    private String text;

    public long getVisitorId() { return visitorId; }
    public void setVisitorId(long visitorId) { this.visitorId = visitorId; }

    public long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(long restaurantId) { this.restaurantId = restaurantId; }

    public int getRate() { return rate; }
    public void setRate(int rate) { this.rate = rate; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
