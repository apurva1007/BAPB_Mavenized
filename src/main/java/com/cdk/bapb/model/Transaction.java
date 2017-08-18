package com.cdk.bapb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tr_id;
    private Bid bid;

    public Transaction() {
    }


    public Transaction(int tr_id, Bid bid) {
        this.tr_id = tr_id;
        this.bid = bid;

    }

    public Transaction(Bid bid) {
        this.bid = bid;
    }

    public int getTr_id() {
        return tr_id;
    }

    public void setTr_id(int tr_id) {
        this.tr_id = tr_id;
    }

    public Bid getBid() {
        return bid;
    }

    public void setB_id(Bid bid) {
        this.bid = bid;
    }
}
