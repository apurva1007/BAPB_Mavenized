import {Component} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {ActivatedRoute} from '@angular/router';

import 'rxjs/Rx';

import {Bid} from "./bid";
import {Car} from "./car";
import {Observable} from "rxjs/Observable";

@Component({
    selector:'makeBid',
    templateUrl:'../partials/addbid.component.html',
    styleUrls:['../css/form.component.css'],
})
export class AddBidComponent{

    title:string ="Make Bid";
    bid: Bid;
    successMessage:string;
    errorMessage:string;
    carId: number=1;
    userId: number;
    car:Car;


    constructor(private http:Http, private activatedRoute:ActivatedRoute) {
        this.bid = new Bid(null,null,null,null);
        // this.activatedRoute.params.subscribe((prms)=>{
        //     this.carId = parseInt(prms['carId']);
        // });
    }

    makeBid() {
        console.log("Inside addBid()!!!!");

        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        /*let getUserUrl = "http://localhost:8080/rest/user/"+this.userId;
        let getCarUrl = "http://localhost:8080/rest/car/"+this.carId;
        let addUrl = "http://localhost:8080/rest/bid/add";
        this.bid.biddingDate = new Date();
        this.http.get(getCarUrl, options).subscribe(res => {
            this.bid.car = res.json();
            this.http.get(getUserUrl, options).subscribe(res => {
                this.bid.user = res.json();
                this.http.post(addUrl, this.bid, options).subscribe(
                    res => {
                        this.successMessage = res.toString();
                        console.log(res.text());
                        this.errorMessage=""
                    },
                    error => {
                        this.errorMessage = <any>error;
                        this.successMessage = ""
                    });
            });
        });*/

        this.bid.biddingDate = new Date();

        Observable.forkJoin(
            this.getUser(),
            this.getCar()
        ).subscribe(res => {
            console.log(res[0]);
            this.bid.user = res[0];
            console.log(res[1]);
            this.bid.car = res[1];

            let addUrl = "http://localhost:8080/rest/bid/add";
            this.http.post(addUrl, this.bid, options).subscribe(
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


        // let addUrl = "http://localhost:8080/rest/bid/add";
        // this.http.post(addUrl, this.bid, options).subscribe(
        //     res => {
        //         this.successMessage = res.toString();
        //         console.log(res.text());
        //         this.errorMessage=""
        //     },
        //     error => {
        //         this.errorMessage = <any>error;
        //         this.successMessage = ""
        //     });
    }

    getUser() {
        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});
        let getUserUrl = "http://localhost:8080/rest/user/"+this.userId;
        return this.http.get(getUserUrl, options).map((res:any) => res.json());
    }

    getCar() {
        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});
        let getCarUrl = "http://localhost:8080/rest/car/"+this.carId;
        return this.http.get(getCarUrl, options).map((res:any) => res.json());
    }
}


