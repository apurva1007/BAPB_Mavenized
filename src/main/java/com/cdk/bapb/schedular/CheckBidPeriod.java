package com.cdk.bapb.schedular;

import com.cdk.bapb.dao.BidDAO;
import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.model.Transaction;
import com.cdk.bapb.service.BidService;
import com.cdk.bapb.service.CarService;
import com.cdk.bapb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class CheckBidPeriod {

    @Autowired
    CarDAO carDAO;

    @Autowired
    BidDAO bidDAO;

    @Autowired
    TransactionService transactionService;

    @Autowired
    CarService carService;

    @Autowired
    BidService bidService;


    @Scheduled(fixedRate = 10000)
    public void checkBidCompleted() {


        Collection<Car> cars = carDAO.getAvailableCars();
        Iterator<Car> itr = cars.iterator();
        while (itr.hasNext()) {
            Car currentCar= itr.next();
           if(carService.readRemainingDays(currentCar.getCarId()) == 0) {
                if(bidService.readBidsByCar(currentCar.getCarId()).size() == 0){
                    currentCar.setBiddingPeriod(currentCar.getBiddingPeriod() + 10);
                    carService.update(currentCar);
                    break;
                }
                currentCar.setAvailable(false);
                carService.update(currentCar);
                Bid highestBid=bidDAO.getHighestBid(currentCar.getCarId());
                transactionService.save(highestBid);

            }
        }
    }

}
