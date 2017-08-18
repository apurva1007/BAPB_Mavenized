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

    public int addTransaction(Transaction transaction) {
        entityManager.persist(transaction);
        return transaction.getTr_id();

    }

    public Collection<Transaction> getAllTransactions() {
        return (entityManager.createQuery("select * from transactions")).getResultList();
    }

}
