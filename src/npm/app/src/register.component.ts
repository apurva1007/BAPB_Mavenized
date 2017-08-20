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
    check:boolean;

    constructor(private http:Http) {
        this.user = new User("","");
    }

    register(){
        var requestHeaders = new Headers({'Content-Type': 'application/json'});
        var options = new RequestOptions({headers: requestHeaders});

        let searchUrl = "http://localhost:8080/rest/search/"+this.user.name + "/" + this.user.phone;

        this.http.get(searchUrl,options).subscribe(res => {
            this.check= res.json();
            console.log(this.check);
            if(this.check == true){
                this.errorMessage = "user already exists";
                return;
            }
            else{
                let addUrl = "http://localhost:8080/rest/addUser";
                this.http.post(addUrl, this.user, options).subscribe(
                    res => {
                        this.successMessage = res.text();
                        console.log(res.text());
                        this.errorMessage = ""
                    },
                    error => {
                        this.errorMessage = <any>error;
                        this.successMessage = ""
                    });
            }
        });


        }
}