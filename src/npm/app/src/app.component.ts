import {Component} from "@angular/core";
import { Router } from '@angular/router';

@Component({
    selector:'bapb-app',
    templateUrl:'../partials/app.component.html',
    styleUrls:['../css/top.navigation.component.css']
})
export class AppComponent{

    constructor(private router:Router){}

}