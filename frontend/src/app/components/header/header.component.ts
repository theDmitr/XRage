import { Component } from "@angular/core";
import { AuthService } from "../../services/auth.service";
import { IonicModule } from "@ionic/angular";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";

@Component({
    selector: "header-component",
    templateUrl: "./header.component.html",
    styleUrl: "./header.component.scss",
    standalone: true,
    imports: [CommonModule, IonicModule, RouterModule],
})
export class HeaderComponent { 
    public isAuthenticated: boolean;

    constructor(private authService: AuthService) {
        this.isAuthenticated = false;
        this.authService.isAuthenticated().then(auth => this.isAuthenticated = auth);
    }
}