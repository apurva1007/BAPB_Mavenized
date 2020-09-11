package com.bapb.service;

import com.bapb.dao.BidDAO;
import com.bapb.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class BidService {

    @Autowired
    BidDAO bidDAO;

    @Transactional
    public int save(Bid bid){


        return bidDAO.save(bid); }

    @Transactional
    public Bid readHighestBid(int carId) {
        return bidDAO.getHighestBid(carId);
    }

    @Transactional
    public Collection<Bid> readBidsByCar(int carId) { return bidDAO.getBidsByCarId(carId);}


    public void setBidDAO(BidDAO bidDAO) {
        this.bidDAO = bidDAO;
    }
}

