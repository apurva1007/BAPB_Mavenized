package com.cdk.bapb.dao;


import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Car;
import com.cdk.bapb.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Date;

@Repository
public class TransactionDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void addTransaction(Bid bid) {
        Transaction transaction = new Transaction(bid);
        entityManager.persist(transaction);
        System.out.println("transaction added");

    }

    public Collection<Transaction> getAllTransactions() {
        return (entityManager.createQuery("select * from transactions")).getResultList();
    }

}
