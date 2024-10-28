import { Routes } from "@angular/router";
import { HomeComponent } from "./components/home/home.component";
import { AboutComponent } from "./components/about/about.component";
import { ServicesComponent } from "./components/services/services.component";
import { AuthComponent } from "./components/login/auth.component";
import { NewsComponent } from "./components/news/news.component";

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'news', component: NewsComponent},
    {path: 'services', component: ServicesComponent},
    {path: 'about', component: AboutComponent},
    {path: 'auth', component: AuthComponent},
];