import {Component, OnInit} from "@angular/core";
import {Http,Headers, RequestOptions} from "@angular/http";
import {Transaction} from "./transaction";
@Component({
    selector:'showSold',
    template:`<div>
        <h2> All Sold Cars </h2>
        <table>
                    <thead>
                    <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Base Selling Price</th>
            <th>Bidding Price</th>
            <th>Sold to</th>
        </tr>
                </thead>
                    <tbody>
                    <tr *ngFor="let trans of transactions">
                            
                              <td>{{trans.bid.car.make}}</td>
                              <td>{{trans.bid.car.model}}</td>
                              <td>{{trans.bid.car.baseSellingPrice}}</td>
            <td>{{trans.bid.biddingPrice}}</td>
            <td>{{trans.bid.user.name}}</td>
        </tr>
        </tbody>
        </table>
    </div>`,
    styleUrls:['../css/form.component.css'],
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