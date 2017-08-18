import {Component, OnInit} from "@angular/core";
import {Http,Headers, RequestOptions} from "@angular/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Bid} from "./bid";

@Component({
    selector:'allBids',
    templateUrl:'../partials/allBids.component.html',
    styleUrls:['../css/form.component.css'],
})
export class AllBidsComponent implements OnInit{
    id:number;
    bids:Bid[];

    constructor(private activatedRoute:ActivatedRoute,private router:Router,private http:Http){
        this.activatedRoute.params.subscribe((prms)=>{
            this.id = parseInt(prms['carId']);
        });
    }

    ngOnInit(){
        var getURL= "http://localhost:8080/rest/car/"+this.id;

        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(getURL, options).subscribe(res => this.bids = res.json());
    }

}