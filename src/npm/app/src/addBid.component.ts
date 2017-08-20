import {Component, OnInit} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {ActivatedRoute} from '@angular/router';

import 'rxjs/Rx';

import {Bid} from "./bid";
import {Car} from "./car";
import {Observable} from "rxjs/Observable";
import {User} from "./user";

@Component({
    selector:'addBid',
    templateUrl:'../partials/addbid.component.html',
    styleUrls:['../css/form.component.css'],
})
export class AddBidComponent{



    title:string ="Make Bid";
    bid: Bid;
    successMessage:string;
    errorMessage:string;
    carId: number;
    userId: number;
    requestHeaders:Headers;
    options:RequestOptions;
    highestBid:Bid;


    constructor(private http:Http, private activatedRoute:ActivatedRoute) {
        this.bid = new Bid(null,null,null,null);
        this.activatedRoute.params.subscribe((prms)=>{
            this.carId = parseInt(prms['carId']);
        });
        this.requestHeaders = new Headers({'Content-Type': 'application/json'});
        this.options = new RequestOptions({headers: this.requestHeaders});

        // Observable.forkJoin(
        //     this.getHighestBid()
        // ).subscribe(res => {
        //     console.log(res[0]);
        //     this.highestBid= res[0];
        //
        // });
    }

    makeBid() {
        console.log("Inside addBid()!!!!");
        this.bid.biddingDate = new Date();

        Observable.forkJoin(
            this.getUser(),
            this.getCar()
        ).subscribe(res => {
            console.log(res[0]);
            this.bid.user = res[0];
            console.log(res[1]);
            this.bid.car = res[1];

            // if (this.bid.biddingPrice < this.highestBid.biddingPrice){
            //     console.log("hie");
            //     this.errorMessage = "bidding price is less than current highestidding price of car.";
            //     return;
            // }
            let addUrl = "http://localhost:8080/rest/bid/add";
            this.http.post(addUrl, this.bid, this.options).subscribe(
                res => {
                    this.successMessage = res.toString();
                    console.log(res.text());
                    this.errorMessage = ""
                },
                error => {
                    this.errorMessage = <any>error;
                    this.successMessage = ""
                });
        });
    }

    getUser() {
        let getUserUrl = "http://localhost:8080/rest/user/"+this.userId;
        return this.http.get(getUserUrl, this.options).map((res:any) => res.json());
    }

    getCar() {
        let getCarUrl = "http://localhost:8080/rest/car/"+this.carId;
        return this.http.get(getCarUrl, this.options).map((res:any) => res.json());
    }

    // getHighestBid(){
    //     var getURL= "http://localhost:8080/rest/highestbid/"+this.carId;
    //
    //     return this.http.get(getURL, this.options).map((res:any) => res.json());
    // }

}


