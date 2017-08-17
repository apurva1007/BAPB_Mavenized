import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpModule } from '@angular/http';
import {AppComponent} from "./app.component";
import {AddCarComponent} from './addcar.component';
import {RegisterComponent} from "./register.component";
import {HomeComponent} from "./home.component";
import {configuredRoutes} from "./routes.config";


@NgModule({
	imports:[BrowserModule,FormsModule,HttpModule,configuredRoutes],
	declarations:[AddCarComponent,AppComponent,HomeComponent,RegisterComponent],
	bootstrap:[AppComponent]
})
export class AppModule{
}

