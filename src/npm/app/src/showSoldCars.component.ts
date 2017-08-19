import {Component, OnInit} from "@angular/core";
import {Http,Headers, RequestOptions} from "@angular/http";
import {Transaction} from "./transaction";
@Component({
    selector:'showSold',
    template:`<div>
        <h1 class="heading"> All Sold Cars </h1>
        <table class="gridtable">
            <tr *ngIf="transactions">
                <th>Make</th><th>Model</th><th>Base Selling Price</th><th>Bidding Price</th><th>Sold to</th>
            </tr>
            <tr *ngFor="let trans of transactions">
                <td>{{trans.bid.car.make}}</td>
                <td>{{trans.bid.car.model}}</td>
                <td>{{trans.bid.car.baseSellingPrice}}</td>
                <td>{{trans.bid.biddingPrice}}</td>
                <td>{{trans.bid.user.name}}</td>
            </tr>
        </table>
        
    </div>`,


    styleUrls:['../css/table.component.styles.css','../css/common.styles.css'],
})
export class ShowSoldCarsComponent implements OnInit{

    transactions:Transaction;

    constructor(private http:Http){}

    ngOnInit(){
        var getSoldCarsURL= "http://localhost:8080/rest/soldCars";

        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(getSoldCarsURL, options).subscribe(res => this.transactions = res.json());
    }
}