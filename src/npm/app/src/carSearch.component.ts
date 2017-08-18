import {Component, OnInit} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {Car} from "./car";


@Component({
	selector:'search',
	templateUrl:'../partials/carSearch.component.html'
})




export class SearchCarComponent implements  OnInit{
	
	cars:Car[];
	searchField:string = "";
    searchFieldValue:string = "";


    constructor(private http:Http) {

    }


    ngOnInit(){

    }

    searchCars() {
    
        var  searchURL = "";

        if(this.searchField === "" && this.searchFieldValue === "") {
            searchURL = "http://localhost:8080/rest/allCars";
        }else{
            searchURL = "http://localhost:8080/rest/car/"+this.searchField+"/"+this.searchFieldValue;
        }


        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(searchURL, options).subscribe(res => this.cars = res.json());
    }

}