package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idV;
    private long idR;
    private int rate;
    private String text="";
    public long getIdV() {
        return idV;
    }
    public long getIdR() {
        return idR;
    }
    public int getRate() {
        return rate;
    }
    public String getText() {
        return text;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Rating() {}
    public Rating(long idV, long idR, int rate, String text) {
        this.idV = idV;
        this.idR = idR;
        id=idV+idR*46341;
        this.rate = rate;
        this.text = text;
    }
    public Rating(long idV, long idR, int rate) {
        this.idV = idV;
        this.idR = idR;
        id=idV+idR*46341;
        this.rate = rate;
    }
}
