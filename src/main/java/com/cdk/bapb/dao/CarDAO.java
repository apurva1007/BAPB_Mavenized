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


    public void update(Car car){
        entityManager.merge(car);
    }

    public int save(Car car) throws Exception {
        System.out.println(car);
        try {
            entityManager.persist(car);
            return car.getCarId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Car selectById(int carId){
        return entityManager.find(Car.class,carId);
    }

    public Collection<Car> selectAll(){
        return entityManager.createQuery("from Car").getResultList();

    }

    public Collection<String> getOptions(String column) {
        return entityManager.createQuery("select "+ column + " from Car").getResultList();
    }

    public Collection<Car> getCars(String field, String fieldValue) {
        return (entityManager.createQuery("from Car where "+field+"='"+fieldValue+"' and available = true")).getResultList();
    }

    public Collection<Car> getAvailableCars() {
        return entityManager.createQuery("from Car where available = true").getResultList();
    }


}
