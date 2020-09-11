package com.bapb.dao;


import com.bapb.model.Bid;
import com.bapb.model.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class TransactionDAO {

    @PersistenceContext
    EntityManager entityManager;

    public int addTransaction(Bid bid) {
        Transaction transaction = new Transaction(bid);
        entityManager.persist(transaction);
        System.out.println("transaction added");
        return transaction.getTrId();

    }

    public Collection<Transaction> getAllTransactions() {
        return (entityManager.createQuery("from Transaction")).getResultList();
    }

}
