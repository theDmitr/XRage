import { Routes } from "@angular/router";
import { HomeComponent } from "./core/components/home/home.component";
import { ClubsComponent } from "./core/components/clubs/clubs.component";
import { AboutComponent } from "./core/components/about/about.component";
import { ServicesComponent } from "./core/components/services/services.component";
import { servicesGuard } from "./core/components/services/services.guard";

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'clubs', component: ClubsComponent},
    {path: 'services', component: ServicesComponent, canActivate: [servicesGuard]},
    {path: 'about', component: AboutComponent},
];