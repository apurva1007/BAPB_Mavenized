import {Component, OnInit} from "@angular/core";
import {Http,Headers, RequestOptions} from "@angular/http";
import {Transaction} from "./transaction";
@Component({
    selector:'showSold',
    templateUrl:'../partials/showSoldCars.component.html',
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