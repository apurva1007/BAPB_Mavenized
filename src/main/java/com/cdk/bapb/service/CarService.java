package com.cdk.bapb.service;

import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.dao.CarRepository;
import com.cdk.bapb.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

    BidService bidService;

    @Autowired
    CarDAO carDAO;

    @Autowired
    CarRepository repo;

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
        return repo.findOne(carId);
    }

    @Transactional
    public Collection<Car> readCars(String field, String fieldValue) {
        return carDAO.getCars(field,fieldValue);
    }

    @Transactional
    public Collection<Car> readAll(){
//        return carDAO.selectAll();
        return repo.findAll();

    }

    public long readRemainingDays(int carId){
        System.out.println("hellloooo");
        Car car = repo.findOne(carId);
        System.out.println(car);
        /*if(bidService.readBidsByCar(car.getCarId()).size() == 0){
            biddingPeriod = biddingPeriod + 10;
        }*/
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
