import {Component} from "@angular/core";
import { Router } from '@angular/router';

@Component({
    selector:'bapb-app',
    template:`<div>
        <div class="topnav" id="myTopnav">
            <h1>{{title}}</h1>
            <input class="button" type="button" value="Register User" (click)="register();" />
            <input class="button" type="button" value="Add Your Car" (click)="addCar();" />
            <input class="button" type="button" value="Search Car" (click)="search();" />
        </div>
       	<router-outlet></router-outlet>      
    </div>`,
    styleUrls:['../css/top.navigation.component.css']
})
export class AppComponent{

    title:string ="BAP Bidders";

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