package com.cdk.bapb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.sql.Timestamp;
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

    private Timestamp entryDate;

    public Car() {
    }

    public Car(String make, String model, int yearOfBuying, int distanceTravelled, double baseSellingPrice, Timestamp entryDate) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
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

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
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
                '}';
    }
}
