package com.cdk.bapb.controller;

import com.cdk.bapb.model.Car;
import com.cdk.bapb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarResourceController {

    @Autowired
    private CarService carService;

   /* private Map<Integer, Car> enteredCars;

    @PostConstruct
    public void init() {
        enteredCars = new HashMap<>();
    }

    @RequestMapping(value = "/addCar",consumes ="application/json" ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public Integer addCar(@RequestBody Car car){
        System.out.println(car);
        int carCounter = enteredCars.size() + 1;
        enteredCars.put(carCounter, car);
        return carCounter;
    }*/


    @RequestMapping(value = "/rest/addCar",consumes =APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
    public String addCar(@RequestBody Car car) throws Exception {
        System.out.println(car);
        int value = carService.add(car);
        return "Car with vin '"+value+" ' added successfully!";
    }

    @RequestMapping(value = "/rest/update/{carId}",consumes = APPLICATION_JSON_VALUE ,method = RequestMethod.PUT)
    public String updateCar(@RequestBody Car car, @PathVariable int carId){
        car.setCarId(carId);
        int value = carService.modify(car);
        return "Car with vin '"+value+" ' resource updated successfully!";
    }

    @RequestMapping(value = "/rest/allCars",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllCarsAsJson(){
        return carService.readAll();
    }

    @RequestMapping(value = "/rest/car/{carId}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Car readById(@PathVariable int carId){
        System.out.println("VIN is : "+carId);
        Car car = carService.readById(carId);
        System.out.println("ReadbyId returns:" + car);
        return car;
    }

    @RequestMapping(value = "/rest/delete/{carId}", method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable int carId){
        carService.remove(carId);
        return "Car with vin '"+carId+"'resource deleted successfully!";
    }
}
