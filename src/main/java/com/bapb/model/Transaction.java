package com.bapb.model;

import javax.persistence.*;


@Entity
@Table(name = "transaction", schema = "bapb")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trId;

    @OneToOne
    private Bid bid;

    public Transaction() {
    }


    public Transaction(int trId, Bid bid) {
        this.trId = trId;
        this.bid = bid;

    }

    public Transaction(Bid bid) {
        this.bid = bid;
    }

    public int getTrId() {
        return trId;
    }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    public Bid getBid() {
        return bid;
    }

    public void setB_id(Bid bid) {
        this.bid = bid;
    }
}
