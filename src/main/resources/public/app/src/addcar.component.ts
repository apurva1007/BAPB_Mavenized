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
        this.car = new Car("Audi", "Q7", "2007",786999,768767.8);
    }

    addCar() {
        console.log("Inside addCar()!!!!");
        let addUrl = "/rest/addCar";

        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        this.car.entryDate = "12-06-2017";
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


