import {Component, OnInit} from "@angular/core";
import { Router,ActivatedRoute } from '@angular/router';
import {Car} from "./car";
import {Http,Headers, RequestOptions} from "@angular/http";

@Component({
    selector:'carDetails',
    templateUrl:'../partials/carDetails.component.html'
})
export class CarDetailsComponent  implements  OnInit{

    car:Car;
    id:number;

    imageUrl=['../images/'+this.id];
    constructor(private activatedRoute:ActivatedRoute,private router:Router,private http:Http){
        this.car = new Car("", "", null, null, null,true );
        this.activatedRoute.params.subscribe((prms)=>{
            this.id = parseInt(prms['carId']);
        });
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

        this.http.get(searchURL, options).subscribe(res => this.car = res.json());
        console.log(this.car);
    }


}