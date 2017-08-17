import { Routes,RouterModule } from '@angular/router';
import {HomeComponent} from "./home.component";
import {RegisterComponent} from "./register.component";
import {AddCarComponent} from "./addcar.component";

let routes:Routes = [
    {path:'home',component:HomeComponent},
    {path:'register',component:RegisterComponent},
    {path:'addCar',component:AddCarComponent},
//    {path:'search',component:SearchComponent},
    {path:'',redirectTo:'/home',pathMatch:'full'}
];

export const configuredRoutes = RouterModule.forRoot(routes);