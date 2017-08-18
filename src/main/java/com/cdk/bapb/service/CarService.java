package com.cdk.bapb.service;

import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.dao.CarRepository;
import com.cdk.bapb.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDAO carDAO;

    @Autowired
    CarRepository repo;

    @Transactional
    public int add(Car car) throws Exception {
        car.setEntryDate(new Timestamp(System.currentTimeMillis()));
        return carDAO.save(car);
    }

    @Transactional
    public int modify(Car car) {
        return carDAO.update(car);
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

    @Transactional
    public void remove(int carId) {
        repo.delete(carId);
    }

}
