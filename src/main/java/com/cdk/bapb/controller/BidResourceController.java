package com.cdk.bapb.controller;

import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BidResourceController {

    @Autowired
    BidService bidService;

    @RequestMapping(value = "/rest/bid/add",consumes ="application/json",method = RequestMethod.POST)
    public String addBid(@RequestBody Bid bid){
        System.out.println(bid);
        int value = bidService.save(bid);
        return "Bid with Bid Id '"+value+" ' added successfully!";
    }

    @RequestMapping(value = "/rest/bid/highestBidder",produces ="application/json",method = RequestMethod.GET)
    public Bid readHighestBid(@RequestBody int carId) {
        Bid bid = readHighestBid(carId);
        return bid;
        /*
    @RequestMapping(value = "/rest/bid/highestBidder",consumes ="application/json" ,method = RequestMethod.POST)
    public String readHighestBid(@RequestBody int carId) {
        Collection<Bid> highestBidder = bidService.readHighestBid(carId);
        System.out.println("====================");
        return "Highest bidder for" + carId + "is : \n \t" + highestBidder ;
    }*/
    }

    @RequestMapping(value = "/rest/bid/{carId}",produces ="application/json" ,method = RequestMethod.GET)
    public Collection<Bid> readAllBidsWithCarId(@RequestBody int carId) {
        return bidService.readBidsByCar(carId);
    }
}
