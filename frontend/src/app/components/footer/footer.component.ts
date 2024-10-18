import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";
import { IonicModule } from "@ionic/angular";

@Component({
    selector: "footer-component",
    templateUrl: "./footer.component.html",
    styleUrl: "./footer.component.scss",
    standalone: true,
    imports: [CommonModule, IonicModule]
})
export class FooterComponent { }