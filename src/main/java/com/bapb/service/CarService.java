package com.bapb.service;

import com.bapb.dao.CarDAO;
import com.bapb.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

@Service
public class CarService {

    BidService bidService;

    @Autowired
    CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Transactional
    public int add(Car car) throws Exception {
        return carDAO.save(car);
    }

    @Transactional
    public void update(Car car){
        carDAO.update(car);
    }

    @Transactional
    public Car readById(int carId) {
        return carDAO.selectById(carId);
    }

    @Transactional
    public Collection<Car> readCars(String field, String fieldValue) {
        return carDAO.getCars(field,fieldValue);
    }

    @Transactional
    public Collection<Car> readAll(){
        return carDAO.selectAll();
    }

    public long readRemainingDays(int carId){
        /*
        * Service function to calculate remaining days of bidding.
        * For particular car, entry date is added with its bidding period.
        * Difference of current date and last bidding date is returned.
        */
        Car car = carDAO.selectById(carId);
        long add = car.getEntryDate().getTime() + car.getBiddingPeriod()*24*60*60*1000;
        Date lastBidDate = new Date(add);
        return (lastBidDate.getTime() - new Date().getTime())/ (1000 * 60 * 60 * 24)+1;
    }
    public Collection<String> readOptions(String column) {
        return carDAO.getOptions(column);
    }

    public Collection<Car> readAllAvailable() {
        return carDAO.getAvailableCars();
    }


}
