"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
const core_1 = require("@angular/core");
const http_1 = require("@angular/http");
const car_1 = require("./car");
let AddCarComponent = class AddCarComponent {
    constructor(http) {
        this.http = http;
        this.title = "Add Car";
        this.car = new car_1.Car("Audi", "Q7", "2007", 786999, 768767.8, "12-06-2017", 10);
    }
    addCar() {
        console.log("Inside addCar()!!!!");
        let addUrl = "/rest/addCar";
        var requestHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: requestHeaders });
        this.http.post(addUrl, this.car, options).subscribe(res => {
            this.successMessage = res.toString();
            console.log(res.text());
            this.errorMessage = "";
        }, error => {
            this.errorMessage = error;
            this.successMessage = "";
        });
    }
};
AddCarComponent = __decorate([
    core_1.Component({
        selector: 'bapb-app',
        templateUrl: '../partials/addcar.component.html',
        styleUrls: ['../css/car.component.styles.css'],
    }), 
    __metadata('design:paramtypes', [http_1.Http])
], AddCarComponent);
exports.AddCarComponent = AddCarComponent;
//# sourceMappingURL=caradd.component.js.map