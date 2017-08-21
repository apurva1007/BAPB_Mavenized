import {Component, OnInit} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";
import {Car} from "./car";


@Component({
	selector:'search',
	templateUrl:'../partials/carSearch.component.html',
    styleUrls:['../css/table.component.styles.css', '../css/search.component.style.css'],
})




export class SearchCarComponent implements  OnInit{
	
	cars:Car[];
	options: String[];
	searchField:string = "";
    searchFieldValue:string = "";
    noOptions:string;


    constructor(private http:Http) {

    }


    ngOnInit(){

    }

    getAvailableOptions(column: string){
        console.log(column);
        let getUrl = "http://localhost:8080/rest/getOptions/"+column;
        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(getUrl, options).subscribe(res => this.options = res.json());
    }

    searchCars() {
    
        var  searchURL = "";

        if(this.searchField === "" && this.searchFieldValue === "") {
            searchURL = "http://localhost:8080/rest/allAvailableCars";
        }else{
            searchURL = "http://localhost:8080/rest/car/"+this.searchField+"/"+this.searchFieldValue;
        }


        var requestHeaders = new Headers({'Accept': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.get(searchURL, options).subscribe(res => {
            this.cars = res.json();
                if(this.cars == null){
                    console.log(this.cars);
                    this.noOptions="No cars available right now. TRy something else.";
                }
        }
        );


    }

}