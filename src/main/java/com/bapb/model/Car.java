package com.bapb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="car", schema = "bapb")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String make;
    private String model;
    private int yearOfBuying;
    private int distanceTravelled;
    private double baseSellingPrice;
    private Date entryDate;
    private boolean available = true;
    private int biddingPeriod =20;

    public Car() {
    }

    public int getBiddingPeriod() {
        return biddingPeriod;
    }

    public void setBiddingPeriod(int biddingPeriod) {
        this.biddingPeriod = biddingPeriod;
    }

    public Car(String make, String model, int yearOfBuying, int distanceTravelled, double baseSellingPrice, Date entryDate, boolean available) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
        this.available = available;
        this.biddingPeriod = 20;
    }

    public Car(int carId,String make, String model, int yearOfBuying, int distanceTravelled, double baseSellingPrice, Date entryDate, boolean available) {
        this.carId=carId;
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
        this.available = available;
    }




    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfBuying() {
        return yearOfBuying;
    }

    public void setYearOfBuying(int yearOfBuying) {
        this.yearOfBuying = yearOfBuying;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getBaseSellingPrice() {
        return baseSellingPrice;
    }

    public void setBaseSellingPrice(double baseSellingPrice) {
        this.baseSellingPrice = baseSellingPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfBuying=" + yearOfBuying +
                ", distanceTravelled=" + distanceTravelled +
                ", baseSellingPrice=" + baseSellingPrice +
                ", entryDate=" + entryDate +
                ", available=" + available +
                ", biddingPeriod=" + biddingPeriod +
                '}';
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
