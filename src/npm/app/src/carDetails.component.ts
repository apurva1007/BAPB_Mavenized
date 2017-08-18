import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from '@angular/router';

@Component({
    selector:'carDetails',
    template:`<div>
        <h1>BAPBiders</h1>
        <p>im in in car details</p>
    </div>`
})
export class CarDetailsComponent implements OnInit{

    constructor(private route:ActivatedRoute) {

    }

    ngOnInit() {
        this.route.params.subscribe(params => {
           let id = params['carId'];
           console.log(" got id : "+id);
        });
    }

}