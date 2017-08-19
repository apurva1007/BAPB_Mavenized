package com.cdk.bapb.service;

import com.cdk.bapb.dao.TransactionDAO;
import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.model.Transaction;
import com.cdk.bapb.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionServiceTest {

    TransactionService transactionService=new TransactionService();

    User user1= new User("Binay","9090896166");
    Car car1 = new Car(1,"Ford", "Ikon", 2017, 12000, 150000,new Date(117, 6, 23),true);
    Bid bid1 = new Bid(1,4000000,new Date(118,07,18),user1,car1);
    Bid bid2 = new Bid(2,4300000,new Date(118,07,18),user1,car1);
    Bid bid3 = new Bid(3,4700000,new Date(118,07,18),user1,car1);
    Transaction transaction1 = new Transaction(bid1);
    Transaction transaction2 = new Transaction(bid2);
    Transaction transaction3 = new Transaction(bid3);
    List<Transaction> list = new ArrayList<Transaction>();


    @Test
    public void testSave() throws Exception {
        TransactionDAO mock = Mockito.mock(TransactionDAO.class);
        Mockito.when(mock.addTransaction((Bid) Matchers.anyObject())).thenReturn(1);
        transactionService.getTransactionDAO(mock);

        int transactionId1 = transactionService.save(bid1);
        Assert.assertEquals(transactionId1,1);
    }

    @Test
    public void testReadAllTransactions() throws Exception {

        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        TransactionDAO mock = Mockito.mock(TransactionDAO.class);
        Mockito.when(mock.getAllTransactions()).thenReturn(list);
        transactionService.getTransactionDAO(mock);

        Collection<Transaction> list1 = transactionService.readAllTransactions();
        Assert.assertEquals(list1,list);
    }

}