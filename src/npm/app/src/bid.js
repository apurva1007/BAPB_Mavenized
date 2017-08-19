"use strict";
var Bid = (function () {
    function Bid(biddingPrice, biddingDate, user, car) {
        this.biddingPrice = biddingPrice;
        this.biddingDate = biddingDate;
        this.user = user;
        this.car = car;
    }
    return Bid;
}());
exports.Bid = Bid;
