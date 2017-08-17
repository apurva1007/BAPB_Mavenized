package com.cdk.bapb.model;

import java.sql.Timestamp;

public class Bid {

    private int b_Id;
    private User user;
    private Car car;
    private double biddingPrice;
    private Timestamp biddingDate;

    public Bid(int b_Id, User user, Car c_Id, double biddingPrice, Timestamp biddingDate) {
        this.b_Id = b_Id;
        this.user = user;
        this.car = c_Id;
        this.biddingPrice = biddingPrice;
        this.biddingDate = biddingDate;
    }

    public Bid() {
    }

    public Bid(User user, Car c_Id, double biddingPrice, Timestamp biddingDate) {
        this.user = user;
        this.car = c_Id;
        this.biddingPrice = biddingPrice;
        this.biddingDate = biddingDate;
    }

    public int getB_Id() {
        return b_Id;
    }

    public void setB_Id(int b_Id) {
        this.b_Id = b_Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getBiddingPrice() {
        return biddingPrice;
    }

    public void setBiddingPrice(double biddingPrice) {
        this.biddingPrice = biddingPrice;
    }

    public Timestamp getBiddingDate() {
        return biddingDate;
    }

    public void setBiddingDate(Timestamp biddingDate) {
        this.biddingDate = biddingDate;
    }
}
