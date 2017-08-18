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
public class BidController {

    @Autowired
    BidService bidService;

    @RequestMapping(value = "/bid/add",consumes ="application/json" ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addBid(@RequestBody Bid bid){
        System.out.println(bid);
        int value = bidService.save(bid);
        return "Bid with Bid Id '"+value+" ' added successfully!";
    }

    @RequestMapping(value = "/bid/highestBidder",consumes ="application/json" ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String readHighestBid(@RequestBody int carId) {
        Collection<Bid> highestBidder = bidService.readHighestBid(carId);
        System.out.println("====================");
        return "Highest bidder for" + carId + "is : \n \t" + highestBidder ;
    }

    @RequestMapping(value = "/bid/bidHistory",consumes ="application/json" ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public void readAllBids() {
        System.out.println("=====================");
        System.out.println("Showing the Bid History:");
    }
}
