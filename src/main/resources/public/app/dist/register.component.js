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
const user_1 = require('./user');
const http_1 = require("@angular/http");
let RegisterComponent = class RegisterComponent {
    constructor(http) {
        this.http = http;
        this.user = new user_1.User("priyal", "3356576788");
    }
    register() {
        var requestHeaders = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: requestHeaders });
        let addUrl = "/rest/addUser";
        console.log(this.user.name);
        console.log(this.user);
        this.http.post(addUrl, this.user, options).subscribe(res => {
            this.successMessage = res.toString();
            console.log(res.text());
            this.errorMessage = "";
        }, error => {
            this.errorMessage = error;
            this.successMessage = "";
        });
    }
};
RegisterComponent = __decorate([
    core_1.Component({
        selector: 'register',
        templateUrl: '../partials/register.component.html',
        styleUrls: ['../css/form.component.css'],
    }), 
    __metadata('design:paramtypes', [http_1.Http])
], RegisterComponent);
exports.RegisterComponent = RegisterComponent;
//# sourceMappingURL=register.component.js.map