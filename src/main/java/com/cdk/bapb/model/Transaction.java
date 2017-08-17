package com.cdk.bapb.model;

import java.util.Date;

public class Transaction {
    private String tr_id;
    private Bid bid;

    public Transaction() {
    }

    public Transaction(String tr_id, Bid bid) {
        this.tr_id = tr_id;
        this.bid = bid;

    }

    public Transaction(Bid bid) {
        this.bid = bid;
    }

    public String getTr_id() {
        return tr_id;
    }

    public void setTr_id(String tr_id) {
        this.tr_id = tr_id;
    }

    public Bid getBid() {
        return bid;
    }

    public void setB_id(Bid bid) {
        this.bid = bid;
    }
}
