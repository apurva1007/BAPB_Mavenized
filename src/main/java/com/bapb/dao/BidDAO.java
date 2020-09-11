package com.bapb.dao;

import com.bapb.model.Bid;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class BidDAO {

    @PersistenceContext
    EntityManager entityManager;

    public int save(Bid bid) {
        entityManager.persist(bid);
        return bid.getBidId();

    }

    public Bid getHighestBid(int carId ) {
        List<Bid> list = (entityManager.createQuery("from Bid where biddingPrice = (select max(biddingPrice) from Bid where car.carId="+carId+")").getResultList());
        if(list.size()==0){
            return null;
        }
        Bid bid = list.get(0);
        return bid;
    }

    public Collection<Bid> getBidsByCarId(int carId) {

        Collection<Bid> list = entityManager.createQuery("from Bid where car.carId = "+ carId).getResultList();
        return list;
    }
}
