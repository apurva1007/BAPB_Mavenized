package com.cdk.bapb.dao;

import com.cdk.bapb.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class CarDAO {

    @PersistenceContext
    EntityManager entityManager;


    public int update(Car car){
        entityManager.merge(car);
        return car.getCarId();
    }

    public int save(Car car){
        System.out.println(car);
        entityManager.persist(car);
        return car.getCarId();
    }

    public Car selectById(int carId){
        return entityManager.find(Car.class,carId);
    }

    public Collection<Car> selectAll(){
        return entityManager.createQuery("from Car").getResultList();

    }

    public void delete(int carId) {
        Car car = entityManager.find(Car.class,carId);
        entityManager.remove(car);
    }
}
