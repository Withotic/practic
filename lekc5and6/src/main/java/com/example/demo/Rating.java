package com.example.demo;
public class Rating {
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
    public Rating(long idV, long idR, int rate, String text) {
        this.idV = idV;
        this.idR = idR;
        this.rate = rate;
        this.text = text;
    }
    public Rating(long idV, long idR, int rate) {
        this.idV = idV;
        this.idR = idR;
        this.rate = rate;
    }
}
