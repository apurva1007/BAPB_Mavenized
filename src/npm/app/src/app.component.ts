import {Component} from "@angular/core";
import { Router } from '@angular/router';

@Component({
    selector:'bapb-app',
    templateUrl:'../partials/app.component.html',
    styleUrls:['../css/top.navigation.component.css']
})
export class AppComponent{

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

    show(){
        var showLink =['/showSold'];
        this.router.navigate(showLink);
    }

    home(){
        var link =[''];
        this.router.navigate(link);
    }

}