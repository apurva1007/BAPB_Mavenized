package com.cdk.bapb.service;

import com.cdk.bapb.dao.BidDAO;
import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BidServiceTest {

    BidService bidService=new BidService();

    User user1= new User("Binay","9090896166");
    Car car1 = new Car(1,"Ford", "Ikon", 2017, 12000, 150000,new Date(117, 6, 23),true);
    Bid bid1 = new Bid(1,4000000,new Date(118,07,18),user1,car1);
    Bid bid2 = new Bid(4300000,new Date(118,07,18),user1,car1);
    Bid bid3 = new Bid(4700000,new Date(118,07,18),user1,car1);
    List<Bid> list = new ArrayList<Bid>();

    @Test
    public void testSave() throws Exception {
        BidDAO mock = Mockito.mock(BidDAO.class);
        Mockito.when(mock.save((Bid) Matchers.anyObject())).thenReturn(bid1.getBidId());
        bidService.setBidDAO(mock);

        int bidId1 = bidService.save(bid1);
        Assert.assertEquals(bidId1,bid1.getBidId());
    }

    @Test
    public void testReadHighestBid() throws Exception {
        BidDAO mock = Mockito.mock(BidDAO.class);
        Mockito.when(mock.getHighestBid(Matchers.anyInt())).thenReturn(bid3);
        bidService.setBidDAO(mock);

        Bid bidTest = bidService.readHighestBid(car1.getCarId());
        Assert.assertEquals(bidTest,bid3);
    }

    @Test
    public void testReadBidsByCar() throws Exception {

        list.add(bid1);
        list.add(bid2);
        list.add(bid3);
        BidDAO mock = Mockito.mock(BidDAO.class);
        Mockito.when(mock.getBidsByCarId(Matchers.anyInt())).thenReturn(list);
        bidService.setBidDAO(mock);

        List<Bid> list1 = (List<Bid>) bidService.readBidsByCar(car1.getCarId());
        Assert.assertEquals(list1,list);
    }

}