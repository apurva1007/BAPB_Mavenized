package com.cdk.bapb.controller;

import com.cdk.bapb.model.Transaction;
import com.cdk.bapb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class TransactionResourceController
{

    @Autowired
    TransactionService transactionService;

    @RequestMapping(value = "/rest/soldCars",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Transaction> readAllSoldCarsAsJson(){
        return transactionService.readAllTransactions();
    }
}