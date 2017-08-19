import {Component} from "@angular/core";
import {Http,Headers,RequestOptions} from "@angular/http";

import {Car} from "./car";

@Component({
	selector:'addCar',
    templateUrl:'../partials/addcar.component.html',
    styleUrls:['../css/form.component.css'],
})
export class AddCarComponent{

	title:string ="Add Car";
	car:Car;
	successMessage:string;
    errorMessage:string;


    constructor(private http:Http) {
        this.car = new Car("", "", null, null, null,new Date(), true,20);
    }

    addCar() {
        console.log("Inside addCar()!!!!");
        let addUrl = "http://localhost:8080/rest/addCar";

        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.http.post(addUrl, this.car, options).subscribe(
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


