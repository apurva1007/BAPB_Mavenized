import {Component} from "@angular/core";

@Component({
    selector:'home',
    template:'<div><h1>{{title}}</h1></div>'
})
export class HomeComponent{

    title:string ="Welcome to BAP Bidders";
}
