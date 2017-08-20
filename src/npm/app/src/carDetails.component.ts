import {Component, OnInit} from "@angular/core";
import { Router,ActivatedRoute } from '@angular/router';
import {Car} from "./car";
import {Http,Headers, RequestOptions} from "@angular/http";
import { DatePipe } from '@angular/common';
import {Bid} from "./bid";

@Component({
    selector:'carDetails',
    templateUrl:'../partials/carDetails.component.html'
})
export class CarDetailsComponent  implements  OnInit{

    car:Car;
    id:number;
    remainingDaysOfBidding: number;
    imageUrl:string;
    bid:Bid;



    constructor(private activatedRoute:ActivatedRoute,private router:Router,private http:Http){
        this.car = new Car("", "", null, null, null,null,true,20);
        this.activatedRoute.params.subscribe((prms)=>{
            this.id = parseInt(prms['carId']);
        });
        this.imageUrl= "../images/image"+this.id+".jpg";
    }



    allBids(){
        var allBidsLink = ['/allBids/',this.id];
        this.router.navigate(allBidsLink);
    }

    makeBid(){
        var makeBidLink = ['/addBid/',this.id];
        this.router.navigate(makeBidLink);
    }

    ngOnInit(){
        var searchURL= "http://localhost:8080/rest/car/"+this.id;

        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(searchURL, options).subscribe(res => {
            this.car = res.json();
        });

        var getDaysURL = "http://localhost:8080/rest/car/remainingDays/"+this.id;
        this.http.get(getDaysURL, options).subscribe(res => {
            this.remainingDaysOfBidding = res.json();
        });

        var getURL= "http://localhost:8080/rest/highestbid/"+this.id;

        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(getURL, options).subscribe(res => this.bid = res.json());
        console.log(this.bid);
    }

}