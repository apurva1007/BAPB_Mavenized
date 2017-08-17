package com.cdk.bapb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String make;
    private String model;
    private String yearOfBuying;
    private int distanceTravelled;
    private double baseSellingPrice;
    private String entryDate;

    /*@OneToOne(targetEntity = User.class)
    private User user;
*/
    public Car() {
    }

    public Car(String make, String model, String yearOfBuying, int distanceTravelled, double baseSellingPrice, String entryDate) {
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
    }

    public Car(int carId, String make, String model, String yearOfBuying, int distanceTravelled, double baseSellingPrice, String entryDate) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.yearOfBuying = yearOfBuying;
        this.distanceTravelled = distanceTravelled;
        this.baseSellingPrice = baseSellingPrice;
        this.entryDate = entryDate;
//        this.user = user;
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

    public String getYearOfBuying() {
        return yearOfBuying;
    }

    public void setYearOfBuying(String yearOfBuying) {
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

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfBuying='" + yearOfBuying + '\'' +
                ", distanceTravelled=" + distanceTravelled +
                ", baseSellingPrice=" + baseSellingPrice +
//                ", user=" + user +
                '}';
    }
}
