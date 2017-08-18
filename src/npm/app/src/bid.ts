


import {User} from "./user";
import {Car} from "./car";

export class Bid{

    bidId: number;
    biddingPrice: number;
    biddingDate: Date;
    user: User;
    car: Car;


    constructor(biddingPrice: number, biddingDate: Date, user: User, car: Car) {
        this.biddingPrice = biddingPrice;
        this.biddingDate = biddingDate;
        this.user = user;
        this.car = car;
    }
}