import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";

@Component({
    selector: "home-component",
    template: "<h1>It`s a home!</h1>",
    standalone: true,
    imports: [CommonModule],
})
export class HomeComponent { }