package com.cdk.bapb.service;

import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.model.Car;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarServiceTest {

    CarService carService = new CarService();

    Car car1 = new Car(1,"Ford", "Ikon", 2017, 12000, 150000,new Date(117, 6, 23),true);
    Car car2 = new Car("Ford", "Mustang", 2007, 125000, 950000,new Date(117, 6, 21),true);
    Car car3 = new Car("Honda", "City", 2003, 105000, 250000,new Date(117, 6, 21),true);
    List<Car> list = new ArrayList<Car>();

    @Test
    public void testAdd () throws Exception {
        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.save((Car) Matchers.anyObject())).thenReturn(car2.getCarId());
        carService.setCarDAO(mock);

        int carId2 = carService.add(car2);
        Assert.assertEquals(carId2,car2.getCarId());

    }

    @Test
    public void testReadById() throws Exception {

        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.selectById(Matchers.anyInt())).thenReturn(car1);
        carService.setCarDAO(mock);

        Car car = carService.readById(5);
        Assert.assertEquals(car,car1);
    }

    @Test
    public void testReadCars() {

        list.add(car1);
        list.add(car2);
        list.add(car3);

        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.getCars(Matchers.anyString(),Matchers.anyString())).thenReturn(list);
        carService.setCarDAO(mock);

        List<Car> list1= (List<Car>) carService.readCars("Make","Ford");
        Assert.assertEquals(list1,list);
    }

    @Test
    public void testReadAll() throws Exception {
        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.selectAll()).thenReturn(list);
        carService.setCarDAO(mock);

        List<Car> list1 = (List<Car>) carService.readAll();
        Assert.assertEquals(list1,list);
    }

    @Test
    public void testReadAllAvailable() throws Exception {
        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.getAvailableCars()).thenReturn(list);
        carService.setCarDAO(mock);

        List<Car> list1 = (List<Car>) carService.readAllAvailable();
        Assert.assertEquals(list1,list);
    }

}