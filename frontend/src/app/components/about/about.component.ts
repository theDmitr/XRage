import { CommonModule } from "@angular/common";
import { Component } from "@angular/core";

@Component({
    selector: "about-component",
    template: "<h1>Ну, мы геи. Всё что нужно о нас знать!</h1>",
    standalone: true,
    imports: [CommonModule],
})
export class AboutComponent { }