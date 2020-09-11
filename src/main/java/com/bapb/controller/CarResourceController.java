package com.bapb.controller;

import com.bapb.model.Car;
import com.bapb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarResourceController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/rest/addCar",consumes =APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
    public String addCar(@RequestBody Car car) throws Exception {
        /*
        * Rest API for adding a new car.
        * Asks for car details and adds it in the table with auto generated car id.
        */
        System.out.println(car);
        int value = carService.add(car);
        return "Car with vin '"+value+" ' added successfully!";
    }

    @RequestMapping(value = "/rest/getOptions/{column}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<String> readOptions(@PathVariable String column){
        /*
        * Rest API for getting options for particular category of  search.
        * Asks for category and returns available options.
        */
        return carService.readOptions(column);
    }

    @RequestMapping(value = "/rest/allCars",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllCarsAsJson(){
        return carService.readAll();
    }

    @RequestMapping(value = "/rest/allAvailableCars",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllAvailableCarsAsJson(){
        /*
        * Returns all available cars.
        */
        return carService.readAllAvailable();
    }

    @RequestMapping(value = "/rest/car/{carId}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Car readById(@PathVariable int carId){
        /*
        * Rest API for getting car by its Id.
        * Asks for car  id and returns available car.
        */
        Car car = carService.readById(carId);
        return car;
    }

    @RequestMapping(value = "rest/car/{field}/{fieldValue}",produces = "application/json" ,method = RequestMethod.GET)
    public Collection<Car> readCarsAccField(@PathVariable String field,@PathVariable String fieldValue){
        /*
        * Rest API for getting according to search field.
        * Asks for category and its value and returns the available car.
        */
        return carService.readCars(field,fieldValue);
    }

    @RequestMapping(value = "/rest/car/remainingDays/{carId}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public long getRemainingDays(@PathVariable int carId){
        /*
        * Rest API for getting remaining days of bidding period.
        * Asks for car id and gives remaining bidding days.
        */
        return carService.readRemainingDays(carId);
    }

}
