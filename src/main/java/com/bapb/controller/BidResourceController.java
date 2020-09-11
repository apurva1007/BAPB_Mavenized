package com.bapb.controller;

import com.bapb.model.Bid;
import com.bapb.model.Car;
import com.bapb.service.BidService;
import com.bapb.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BidResourceController {


    @Autowired
    BidService bidService;

    @Autowired
    CarService carService;

    @RequestMapping(value = "/rest/bid/add",consumes ="application/json",method = RequestMethod.POST)
    public String addBid(@RequestBody Bid bid){
        /*
        * Rest API for adding a new bid.
        */
        System.out.println(bid);
        int value = bidService.save(bid);
        return "Bid with Bid Id '"+value+" ' added successfully!";
    }

    @RequestMapping(value = "/rest/highestbid/{carId}",produces ="application/json",method = RequestMethod.GET)
    public Bid readHighestBid(@PathVariable int carId) {
        /*
        * Rest API for getting highest bid on a car.
        * Asks for car id and returns the highest bid made on it.
        */
        Bid bid = bidService.readHighestBid(carId);
        return bid;
    }

    @RequestMapping(value = "/rest/validBid/{carId}/{price}",produces ="application/json",method = RequestMethod.GET)
    public boolean readHighestBid(@PathVariable int carId, @PathVariable int price) {
        Bid bid = bidService.readHighestBid(carId);
        Car car = carService.readById(carId);
        System.out.println(car.getBaseSellingPrice());
        if(bid!=null)
            return (bid.getBiddingPrice() < price);
        else
            return (car.getBaseSellingPrice() < price);
    }


    @RequestMapping(value = "/rest/bid/{carId}",produces ="application/json" ,method = RequestMethod.GET)
    public Collection<Bid> readAllBidsWithCarId(@PathVariable int carId) {
        /*
        * Rest API for getting all bids made on the car.
        * Asks for car id and return all bids made on it.
        */
        return bidService.readBidsByCar(carId);
    }
}
