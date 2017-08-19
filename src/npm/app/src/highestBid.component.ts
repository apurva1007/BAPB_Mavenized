import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Http,Headers, RequestOptions} from "@angular/http";
import {Bid} from "./bid";
@Component({
    selector:'highestBid',
    templateUrl:'../partials/highest.component.html',
    styleUrls:['../css/form.component.css'],
})
export class HighestBidComponent {
    id:number;
    bid:Bid;

    constructor(private activatedRoute:ActivatedRoute,private router:Router,private http:Http){
        this.bid = new Bid(null,null,null,null);
        this.activatedRoute.params.subscribe((prms)=>{
            this.id = parseInt(prms['carId']);
        });

    }

    ngOnInit(){
        var getURL= "http://localhost:8080/rest/highestbid/"+this.id;

        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(getURL, options).subscribe(res => this.bid = res.json());


    }

}