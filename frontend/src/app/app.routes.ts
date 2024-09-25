import { Routes } from "@angular/router";
import { HomeComponent } from "./shared/components/home/home.component";
import { ClubsComponent } from "./shared/components/clubs/clubs.component";
import { AboutComponent } from "./shared/components/about/about.component";
import { ServicesComponent } from "./shared/components/services/services.component";

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'clubs', component: ClubsComponent},
    {path: 'services', component: ServicesComponent},
    {path: 'about', component: AboutComponent},
];