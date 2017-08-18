package com.cdk.bapb.schedular;

import com.cdk.bapb.dao.BidDAO;
import com.cdk.bapb.dao.CarDAO;
import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.model.Transaction;
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

    TransactionService transactionService;

    @Scheduled(fixedRate = 10000)
    public void checkBidCompleted() {


        Collection<Car> cars = carDAO.getAvailableCars();
        Iterator<Car> itr = cars.iterator();
        while (itr.hasNext()) {
            Car currentCar= itr.next();
            if(new Date().getTime()-currentCar.getEntryDate().getTime()==20) {
                currentCar.setAvailable(false);
                Bid highestBid=bidDAO.getHighestBid(currentCar.getCarId());
                transactionService.save(highestBid);

            }
        }
    }

}
