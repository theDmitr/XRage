import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";
import { AuthService } from "../../services/auth.service";
import { FormsModule } from "@angular/forms";

@Component({
    selector: "authComponent",
    templateUrl: "./auth.component.html",
    styleUrl: "./auth.component.scss",
    standalone: true,
    imports: [CommonModule, FormsModule],
})
export class AuthComponent {
    public username: string = "";
    public password: string = "";

    constructor(private authService: AuthService) {}

    auth() {
        this.authService.auth(this.username, this.password);
    }
}