package com.cdk.bapb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bidding_details", schema = "bapb")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bidId;
    private double biddingPrice;
    private Date biddingDate;

    @OneToOne
    User user;

    @OneToOne
    Car car;

    public Bid() {
    }

    public Bid(double biddingPrice, Date biddingDate, User user, Car car) {
        this.biddingPrice = biddingPrice;
        this.biddingDate = biddingDate;
        this.user = user;
        this.car = car;
    }

    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public double getBiddingPrice() {
        return biddingPrice;
    }

    public void setBiddingPrice(double biddingPrice) {
        this.biddingPrice = biddingPrice;
    }

    public Date getBiddingDate() {
        return biddingDate;
    }

    public void setBiddingDate(Date biddingDate) {
        this.biddingDate = biddingDate;
    }

//    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", biddingPrice=" + biddingPrice +
                ", biddingDate=" + biddingDate +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
