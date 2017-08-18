package com.cdk.bapb.dao;

import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class BidDAO {

    @PersistenceContext
    EntityManager entityManager;

    public int save(Bid bid) {
        entityManager.persist(bid);
        return bid.getBidId();

    }

    public Bid getHighestBid(int carId ) {
        //return (entityManager.createQuery("select * from bidding_details where biddingPrice=(select maxelement(bidding_price) from Bid where car_car_id = carId)")).getResultList();
        return null;
    }

    public Collection<Bid> getBidsByCarId(int carId) {
        return (entityManager.createQuery("* from bidding_details where car_car_id = carId")).getResultList();
    }
}
