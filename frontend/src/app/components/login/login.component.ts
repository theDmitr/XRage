import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";

@Component({
    selector: "loginComponent",
    templateUrl: "./login.component.html",
    styleUrl: "./login.component.scss",
    standalone: true,
    imports: [CommonModule],
})
export class LoginComponent {
}