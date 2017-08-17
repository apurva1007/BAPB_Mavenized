import {Component} from "@angular/core";
import {User} from './user';
import {Http,Headers, RequestOptions} from "@angular/http";

@Component({
    selector:'register',
    templateUrl:'../partials/register.component.html',
    styleUrls:['../css/form.component.css'],
})
export class RegisterComponent{

    user:User;
    successMessage:string;
    errorMessage:string;

    constructor(private http:Http) {
        this.user = new User("priyal","3356576788");
    }

    register(){
        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});
        let addUrl = "/rest/addUser";

        console.log(this.user.name);
        console.log(this.user);

        this.http.post(addUrl, this.user, options).subscribe(
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