"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var ShowSoldCarsComponent = (function () {
    function ShowSoldCarsComponent(http) {
        this.http = http;
    }
    ShowSoldCarsComponent.prototype.ngOnInit = function () {
        var _this = this;
        var getSoldCarsURL = "http://localhost:8080/rest/soldCars";
        var requestHeaders = new http_1.Headers({ 'Accept': 'application/json' });
        var options = new http_1.RequestOptions({ headers: requestHeaders });
        this.http.get(getSoldCarsURL, options).subscribe(function (res) { return _this.transactions = res.json(); });
    };
    ShowSoldCarsComponent = __decorate([
        core_1.Component({
            selector: 'showSold',
            template: "<div>\n        <h2> All Sold Cars </h2>\n        <table>\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<thead>\n        \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<tr>\n            <th>Make</th>\n            <th>Model</th>\n            <th>Base Selling Price</th>\n            <th>Bidding Price</th>\n            <th>Sold to</th>\n        </tr>\n        \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002</thead>\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<tbody>\n        \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<tr *ngFor=\"let trans of transactions\">\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<td>{{trans.bid.car.make}}</td>\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<td>{{trans.bid.car.model}}</td>\n            \u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002\u2002<td>{{trans.bid.car.baseSellingPrice}}</td>\n            <td>{{trans.bid.biddingPrice}}</td>\n            <td>{{trans.bid.user.name}}</td>\n        </tr>\n        </tbody>\n        </table>\n    </div>",
            styleUrls: ['../css/form.component.css'],
        })
    ], ShowSoldCarsComponent);
    return ShowSoldCarsComponent;
}());
exports.ShowSoldCarsComponent = ShowSoldCarsComponent;
