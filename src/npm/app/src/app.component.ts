import {Component} from "@angular/core";
import { Router } from '@angular/router';

@Component({
    selector:'bapb-app',
    template:`<div>
        <h1 align="center">{{title}}</h1>
        <input type="button" value="Register" (click)="register();" />
        <input type="button" value="Add Your Car" (click)="addCar();" />
        <input type="button" value="SEARCH" (click)="search();" />
       	<router-outlet></router-outlet>      
    </div>`
})
export class AppComponent{

    title:string ="BAPBidders";

    constructor(private router:Router){}

    register(){
        var registerLink =['/register'];
        this.router.navigate(registerLink);
    }

    addCar(){
        var addCarLink =['/addCar'];
        this.router.navigate(addCarLink);
    }

    search(){
        var searchLink =['/search'];
        this.router.navigate(searchLink);
    }
}