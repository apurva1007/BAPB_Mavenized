package com.cdk.bapb.service;

import com.cdk.bapb.dao.TransactionDAO;
import com.cdk.bapb.model.Bid;
import com.cdk.bapb.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class TransactionService {

    @Autowired
    TransactionDAO transactionDAO;

    @Transactional
    public int save(Transaction transaction){ return transactionDAO.addTransaction(transaction); }

    @Transactional
    public Collection<Transaction> readAllTransactions () {
        return transactionDAO.getAllTransactions();
    }

}
