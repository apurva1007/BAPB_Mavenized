package com.cdk.bapb.service;

import com.cdk.bapb.dao.BidDAO;
import com.cdk.bapb.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class BidService {


    @Autowired
    BidDAO bidDAO;

    @Transactional
    public int save(Bid bid){ return bidDAO.save(bid); }

    @Transactional
    public Collection<Bid> readHighestBid(int carId ) {return bidDAO.getHighestBid(carId);}

    @Transactional
    public Collection<Bid> readAllBids() { return bidDAO.getAllBids();}


}

