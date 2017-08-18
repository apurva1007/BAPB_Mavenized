import { Routes,RouterModule } from '@angular/router';
import {HomeComponent} from "./home.component";
import {RegisterComponent} from "./register.component";
import {AddCarComponent} from "./addcar.component";
import {CarDetailsComponent} from "./carDetails.component";
import {SearchCarComponent} from "./carSearch.component";
import {AddBidComponent} from "./addBid.component";

let routes:Routes = [
    {path:'home',component:HomeComponent},
    {path:'register',component:RegisterComponent},
    {path:'addCar',component:AddCarComponent},
    {path:'addBid',component:AddBidComponent},
    {path:'search',component:SearchCarComponent},
    {path:'carDetails/:carId',component:CarDetailsComponent},
    {path:'',redirectTo:'/home',pathMatch:'full'}
];

export const configuredRoutes = RouterModule.forRoot(routes);