import {Bid} from "./bid";

export class Transaction{
    trId:number;
    bid:Bid;

    constructor(bid:Bid){
        this.bid = bid;
    }
}