import {Component, OnInit} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {ActivatedRoute} from '@angular/router';

import 'rxjs/Rx';

import {Bid} from "./bid";
import {Observable} from "rxjs/Observable";

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
    check:boolean;


    constructor(private http:Http, private activatedRoute:ActivatedRoute) {
        this.bid = new Bid(null,null,null,null);
        this.activatedRoute.params.subscribe((prms)=>{
            this.carId = parseInt(prms['carId']);
        });
        this.requestHeaders = new Headers({'Content-Type': 'application/json'});
        this.options = new RequestOptions({headers: this.requestHeaders});

    }

    makeBid() {
        console.log("Inside addBid()!!!!");
        this.bid.biddingDate = new Date();

        console.log(this.userId);

        let searchUrl = "http://localhost:8080/rest/validBid/"+this.carId + "/" + this.bid.biddingPrice;

        this.http.get(searchUrl,this.options).subscribe(res => {
            this.check= res.json();
            console.log(this.check);
            if(this.check != true){
                this.errorMessage = "Bid price is invalid!!";
                return;
            }
            else {

                let searchUrl = "http://localhost:8080/rest/isUser/" + this.userId;

                this.http.get(searchUrl, this.options).subscribe(res => {
                    this.check = res.json();
                    console.log(this.check);
                    if (this.check != true) {
                        this.errorMessage = "User does not exist. Register to make a bid!!";
                        return;
                    }
                    else {
                        Observable.forkJoin(
                            this.getUser(),
                            this.getCar()
                        ).subscribe(res => {
                            console.log(res[0]);
                            this.bid.user = res[0];
                            console.log(res[1]);
                            this.bid.car = res[1];

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
                });
            }
        });

    }

    addBid() {

    }

    getUser() {
        let getUserUrl = "http://localhost:8080/rest/user/"+this.userId;
        return this.http.get(getUserUrl, this.options).map((res:any) => res.json());
    }

    getCar() {
        let getCarUrl = "http://localhost:8080/rest/car/"+this.carId;
        return this.http.get(getCarUrl, this.options).map((res:any) => res.json());
    }

}


