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

    public Collection<Bid> getHighestBid(int carId ) {
        return (entityManager.createQuery("select * from Bid where biddingPrice=(select maxelement(biddingPrice) from Bid where car.carId = carId)")).getResultList();
    }

    public Collection<Bid> getListBidsByCarId(Car car) {
        return (entityManager.createQuery("* from Bid where user.userId = car.carId")).getResultList();
    }

    public Collection<Bid> getAllBids() {
        return (entityManager.createQuery("select * from Bid ")).getResultList();
    }



}
