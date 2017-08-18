import {Component} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";

import {Bid} from "./bid";

@Component({
	selector:'addBid',
    templateUrl:'../partials/addbid.component.html',
    styleUrls:['../css/form.component.css'],
})
export class AddBidComponent{

	title:string ="Add Bid";
	bid: Bid;
	successMessage:string;
    errorMessage:string;


    constructor(private http:Http) {
       // this.bid = new Bid(23000,new Date(),);
    }

    addBid() {
        console.log("Inside addBid()!!!!");
        let addUrl = "/rest/bid/add";

        console.log(this.bid);

        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

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
    }
}


