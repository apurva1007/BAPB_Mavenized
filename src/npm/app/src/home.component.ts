import {Component, OnInit} from "@angular/core";

@Component({
    selector:'home',
    templateUrl:'../partials/home.component.html',
    styleUrls:['https://www.w3schools.com/w3css/4/w3.css', '../css/common.styles.css'],
})
export class HomeComponent {

    title:string ="Welcome to BAP Bidders";

    // slideIndex:number = 1;
    //
    // plusDivs(n:number) {
    //     this.showDivs(this.slideIndex += n);
    // }
    //
    // currentDiv(n:number) {
    //     this.showDivs(this.slideIndex = n);
    // }
    //
    // showDivs(n:number) {
    //     let i:number;
    //     let x = document.getElementsByClassName("mySlides");
    //     let dots = document.getElementsByClassName("demo");
    //     if (n > x.length) {this.slideIndex = 1}
    //     if (n < 1) {this.slideIndex = x.length}
    //     for (i = 0; i < x.length; i++) {
    //         x[i].setAttribute("style","display = \"none\";");
    //     }
    //     for (i = 0; i < dots.length; i++) {
    //         dots[i].className = dots[i].className.replace(" w3-white", "");
    //     }
    //     x[this.slideIndex-1].setAttribute("style","display = \"none\";");
    //     dots[this.slideIndex-1].className += " w3-white";
    // }
    //
    // ngOnInit(){
    //     this.showDivs(this.slideIndex);
    //     console.log("inside");
    // }inside

}
