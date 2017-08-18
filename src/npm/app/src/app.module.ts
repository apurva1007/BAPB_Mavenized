import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import {AppComponent} from "./app.component";
import {AddCarComponent} from './addcar.component';
import {RegisterComponent} from "./register.component";
import {HomeComponent} from "./home.component";
import {configuredRoutes} from "./routes.config";
import {SearchCarComponent} from "./carSearch.component";
import {CarDetailsComponent} from "./carDetails.component";
import {AddBidComponent} from "./addBid.component";


@NgModule({
	imports:[BrowserModule,FormsModule,HttpModule,configuredRoutes],
	declarations:[AddCarComponent,AppComponent,HomeComponent,RegisterComponent,SearchCarComponent,CarDetailsComponent, AddBidComponent],
	bootstrap:[AppComponent]
})
export class AppModule{
}

